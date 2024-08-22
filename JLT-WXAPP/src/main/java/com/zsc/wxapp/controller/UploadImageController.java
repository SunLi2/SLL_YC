package com.zsc.wxapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zsc.tpg.clients.Remote;

import com.zsc.wxapp.entity.PythonResponse;
import com.zsc.wxapp.entity.RequestDto;
import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.external.Product;
import com.zsc.wxapp.exservices.Remote2;
import com.zsc.wxapp.services.IPriceTagService;
import com.zsc.wxapp.services.IUploadImageService;
import com.zsc.wxapp.services.impl.DataService;
import com.zsc.wxapp.services.impl.ImageInferenceService;
import com.zsc.wxapp.utils.OSSUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

@RestController
@RequestMapping("/api/upload")
@Slf4j
public class UploadImageController {

    @Autowired
    private OSSUploadUtil ossUploadUtil;

    @Autowired
    private ImageInferenceService imageInferenceService;

    @Autowired
    private IPriceTagService priceTagService;

    @Value("${api.local.url}")
    private String apiLocalUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DataService dataService;

    @Autowired
    private IUploadImageService uploadImageService;

    @Autowired
    private Remote2 remote2;

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

        Pair<PythonResponse,String> result_total = performInferenceOnImageStream(file);
        PythonResponse result = result_total.getLeft();
        String url=result_total.getRight();
        List<List<String>> res=result.getRes();
        List<String> listName=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            listName.add(res.get(i).get(0));
        }
        List<Product> result_price =remote2.getPriceByNames(listName);

        List<String> res_lose_tag=result.getRes_lose_tag();
        JSONObject responseJson = new JSONObject();
        responseJson.put("res", res);
        responseJson.put("res_lose_tag", res_lose_tag);
        responseJson.put("res_price",result_price);
        responseJson.put("url",url);

        // 将 JSON 对象转换为字符串并返回
        return ResponseEntity.ok(responseJson.toString());
    }

    /**
     * 本地上传图片
     * @param file
     * @param userid
     * @return
     * @throws IOException
     */
    @PostMapping("/local_imagesbed_Upload")
    public ResponseEntity<String>  local_imagesbed_Upload(@RequestParam("file") MultipartFile file, @RequestParam("userid") String userid) throws IOException {
//        System.out.println(file.toString());
//        System.out.println(userid);
        // 处理上传的文件
        if (file == null) {
            System.out.println("file==null");
            return null;
        }

        String url = uploadImageService.local_ImageBed_Upload(file, userid);

        Pair<PythonResponse, String> result_total = uploadImageService.Remote_Python_PriceTagRecognition(file, url);

        PythonResponse result = result_total.getLeft();
        url=result_total.getRight();
        List<List<String>> res=result.getRes();
        List<String> listName=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            listName.add(res.get(i).get(0));
        }
        List<Product> result_price =remote2.getPriceByNames(listName);

        List<String> res_lose_tag=result.getRes_lose_tag();
        JSONObject responseJson = new JSONObject();
        responseJson.put("res", res);
        responseJson.put("res_lose_tag", res_lose_tag);
        responseJson.put("res_price",result_price);
        responseJson.put("url",url);

        // 将 JSON 对象转换为字符串并返回
        log.info("返回的数据，json：{}", responseJson);
        return ResponseEntity.ok(responseJson.toString());

//        String code = (String) objectMap.get("code");
//        if (code==null) {
//            return Result.fail("图片上传失败!",null);
//        }
//        if(code.equals("404")){
//            return Result.fail((String) objectMap.get("msg"),null);
//        }
//        return Result.ok("图片上传成功！",objectMap);

        // ok 后面再说把，你是不是需要操作电脑
    }

    /**
     * 远程调用python
     * @param imageStream
     * @return
     * @throws IOException
     */
    private Pair<PythonResponse,String> performInferenceOnImageStream(MultipartFile imageStream) throws IOException {
        //阿里云
        String url_image=uploadImageService.Aliyun_Image_Upload(imageStream);
        // 本地
//        String url_image=uploadImageService.local_ImageBed_Upload(imageStream,"9527");

        String fullUrl = apiLocalUrl + "/detect";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("apikey", "oE2PzTohoiDMwbUIZuJXyGK2Shzd1de");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file_list", imageStream.getResource());
        body.add("model_name", "custom");
        body.add("download_image", "true");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(fullUrl, HttpMethod.POST, requestEntity, String.class);
        String responseBody = response.getBody();
        log.info("远程服务接口返回的数据是：{}", responseBody);


//        String url_image="https://zsc9528.oss-cn-shenzhen.aliyuncs.com/16703d8d-bae4-4443-a99b-100090be482a_NFbzVXFrc2qP85449c0557b37fbc00f7e5b2e7162a97.jpg";
//
        String url = "http://localhost:5000/inference";
        MultiValueMap<String, Object> body_2 = new LinkedMultiValueMap<>();
        body_2.add("data", responseBody);  // JSON 字符串作为普通字符串
        body_2.add("url", url_image);
        body_2.add("image", new InputStreamResource(imageStream.getInputStream()));  // 文件对象
        HttpHeaders headers_2 = new HttpHeaders();
        headers_2.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity_2 = new HttpEntity<>(body_2, headers_2);
        ResponseEntity<String> response_2 = restTemplate.postForEntity(url, requestEntity_2, String.class);
        String jsonResponse_2 = response_2.getBody();

//        String jsonResponse_2 = "{"
//                + "\"res\":["
//                + "[\"\\u8299\\u84c9\\u738b(\\u786c)\",\"25\",true],"
//                + "[\"\\u53cc\\u559c\",\"17\",false]"
//                + "],"
//                + "\"res_lose_tag\":["
//                + "\"\\u4e2d\\u534e\\u6d77(5mg)\","
//                + "\"\\u9ec4\\u91d1\\u53f6(\\u559c\\u6ee1\\u5802)\""
//                + "]"
//                + "}";

        if (jsonResponse_2 != null) {
            try {
                // 使用 ObjectMapper 将 JSON 字符串转换为 PythonResponse 对象
                PythonResponse pythonResponse=objectMapper.readValue(jsonResponse_2, PythonResponse.class);
                return Pair.of(pythonResponse,url_image);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return Pair.of(new PythonResponse(),url_image);
    }


    @PostMapping("/uploadData")
    public String handleUpload(@RequestBody RequestDto requestDto) {
        dataService.processRequest(requestDto);
        return "Data processed successfully";
    }

    @PostMapping("/local_imagesbed_Save")
    public Result Localimagesbed_Save(@RequestParam("file") MultipartFile file, @RequestParam("userid") String userid) {
        System.out.println(file.toString());
        System.out.println(userid);
        // 处理上传的文件
        if (file == null) {
            System.out.println("file==null");
            return Result.fail("上传文件为空！");
        }
        Map<String, Object> objectMap = uploadImageService.localImagesBed_Upload(file, userid);
        String code = (String) objectMap.get("code");
        if (code==null) {
            return Result.fail("图片上传失败!",null);
        }
        if(code.equals("404")){
            return Result.fail((String) objectMap.get("msg"),null);
        }


        return Result.ok("图片上传成功！",objectMap);
    }

}


