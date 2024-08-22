package com.zsc.wxapp.controller;


import com.zsc.wxapp.entity.PicUrl;
import com.zsc.wxapp.entity.Result;
import com.zsc.wxapp.services.IImageInferenceService;
import com.zsc.wxapp.services.IPicUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/picurl")
public class PicUrlController {

    @Autowired
    private IPicUrlService  picUrlService;

    @Autowired
    private IImageInferenceService imageInferenceService;

    @GetMapping("/latest_images")
    public Result getLatestUploadImagesByUserid(@RequestParam("userid") String userid) {

        PicUrl picUrl = picUrlService.findByLatestCreatetime(userid);

        if(picUrl == null) {
            return Result.fail(userid+"该用户没有图片！");
        }

        return Result.ok("返回成功！",picUrl);
    }



}
