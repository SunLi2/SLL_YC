package com.zsc.wxapp.services.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.CannedAccessControlList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsc.wxapp.clients.LocalImagesBedClient;
import com.zsc.wxapp.clients.RemotePriceTagRecognition;
import com.zsc.wxapp.clients.pythonPriceTagRecognitionClient;
import com.zsc.wxapp.entity.PicUrl;
import com.zsc.wxapp.entity.PythonResponse;
import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.entity.external.Product;
import com.zsc.wxapp.exservices.Remote2;
import com.zsc.wxapp.mapper.PicUrlMapper;
import com.zsc.wxapp.services.IUploadImageService;
import com.zsc.wxapp.utils.IpAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class UploadImageService  implements IUploadImageService {


    @Autowired
    private Remote2 remote2;

    @Value("${api.local.url}")
    private String apiLocalUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DataService dataService;

    @Autowired
    private OSS ossClient;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Value("${aliyun.oss.dir.prefix}")
    private String dirPrefix;

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Autowired
    private pythonPriceTagRecognitionClient priceTagRecognitionClient;

    @Autowired
    private RemotePriceTagRecognition remotePriceTagRecognition;

    @Autowired
    private LocalImagesBedClient localImagesBedClient;

    @Value("${localimagesbed.port}")
    private String local_images_bed_port;
    @Autowired
    private PicUrlMapper picUrlMapper;

    /**
     * 阿里云图片上传
     *
     * @param file：MultipartFile 图片
     * @return 图片Url
     */

    @Override
    public String Aliyun_Image_Upload(MultipartFile file) {
        String url = null;
        try {
            InputStream inputStream = file.getInputStream();
            String originFileName = file.getOriginalFilename();
            String uuidFileName = UUID.randomUUID().toString() + originFileName;

            ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String dateTime = beijingDateTime.format(formatter);

            String realFileName = dateTime + "_" + uuidFileName;
            String dirFileName = dirPrefix + realFileName;

            ossClient.putObject(bucketName, dirFileName, inputStream);
            /// 设置对象为公共读
            ossClient.setObjectAcl(bucketName, dirFileName, CannedAccessControlList.PublicRead);

            url = "https://" + bucketName + "." + endpoint + "/" + dirFileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }


    /**
     * 本地图传上传
     *
     * @param file：MultipartFile 图片
     * @return 图片Url
     */
    @Override
    public String local_ImageBed_Upload(MultipartFile file, String userid) {
        String url=null;
        Result result = localImagesBedClient.upload_save_image(file, userid);
        if (!result.getCode().equals("200")) {

            return null;
        }
         url= "http://"+IpAddressUtil.getIpAddress() + ":" + local_images_bed_port + result.getData().toString();

//        url= IpAddressUtil.getIpAddress() + ":" + local_images_bed_port + result.getData().toString();
        System.out.println("url="+url);
        PicUrl picUrl = new PicUrl();
        picUrl.setPic_userid(userid);
        String urlid = UUID.randomUUID().toString();
        ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String create_time = beijingDateTime.format(formatter);
        picUrl.setPic_create_time(create_time);
        picUrl.setPic_urlid(urlid);
        picUrl.setPic_url(url);

        return url;
    }


    /**
     * 本地图片上传
     * @param file
     * @param userid
     * @return
     */
    public Map<String, Object> localImagesBed_Upload(MultipartFile file, String userid) {

        Result result = localImagesBedClient.upload_save_image(file, userid);
        if (!result.getCode().equals("200")) {

            return null;
        }

        String url= "http://"+IpAddressUtil.getIpAddress() + ":" + local_images_bed_port + result.getData().toString();
        System.out.println("url="+url);
        PicUrl picUrl = new PicUrl();
        picUrl.setPic_userid(userid);
        String urlid = UUID.randomUUID().toString();
        ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String create_time = beijingDateTime.format(formatter);
        picUrl.setPic_create_time(create_time);
        picUrl.setPic_urlid(urlid);
        picUrl.setPic_url(url);
        System.out.println(picUrl.toString());
        int insert = picUrlMapper.insert(picUrl);
        if(insert<=0){
            Map<String, Object> response = new HashMap<>();
            response.put("code", 404);
            response.put("msg", "插入失败");
            return response;
        }

        ResponseEntity<String> responseEntity = remotePriceTagRecognition.remotePriceTagRecognition(file, "custom", "true");
        System.out.println("responseEntity="+responseEntity);
        String data = responseEntity.getBody();

//        InputStreamResource inputStreamResource = null;
//        try {
//            inputStreamResource = new InputStreamResource(file.getInputStream());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        // 图片识别
        ResponseEntity<String> stringResponseEntity = priceTagRecognitionClient.pythonPriceTagRecognition(data,url,file);
        String body = stringResponseEntity.getBody();


        if (body == null) {
            return null;
        }
        PythonResponse pythonResponse = null;
        try {
            pythonResponse = objectMapper.readValue(body, PythonResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        List<List<String>> res = pythonResponse.getRes();
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            listName.add(res.get(i).get(0));
        }

        List<Product> result_price = remote2.getPriceByNames(listName);
        List<String> res_lose_tag = pythonResponse.getRes_lose_tag();
        Map<String, Object> response = new HashMap<>();
        response.put("res", res);
        response.put("res_lose_tag", res_lose_tag);
        response.put("res_price", result_price);
        response.put("url", url);
        // 将 JSON 对象转换为字符串并返回
        return response;
    }

    // python 价签识别推理代码
    @Override
    public Pair<PythonResponse,String> Remote_Python_PriceTagRecognition(MultipartFile imageStream, String url_image) throws IOException {
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

        String url = "http://localhost:5000/inference";
//        String url_image="https://zsc9528.oss-cn-shenzhen.aliyuncs.com/16703d8d-bae4-4443-a99b-100090be482a_NFbzVXFrc2qP85449c0557b37fbc00f7e5b2e7162a97.jpg";
//
        MultiValueMap<String, Object> body_2 = new LinkedMultiValueMap<>();
        body_2.add("data", responseBody);  // JSON 字符串作为普通字符串
        body_2.add("url", url_image);
        body_2.add("image", new InputStreamResource(imageStream.getInputStream()));  // 文件对象
        HttpHeaders headers_2 = new HttpHeaders();
        headers_2.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity_2 = new HttpEntity<>(body_2, headers_2);
        ResponseEntity<String> response_2 = restTemplate.postForEntity(url, requestEntity_2, String.class);
        String jsonResponse_2 = response_2.getBody();
//        log.info("返回的数据是：{}", jsonResponse_2);

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
}
