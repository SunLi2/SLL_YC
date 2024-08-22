package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.PythonResponse;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface IUploadImageService {
    // 阿里云上传图片，返回url
    String Aliyun_Image_Upload(MultipartFile file);

    // 本地图传上传
    String local_ImageBed_Upload(MultipartFile file, String userid);

    // python 价签识别推理代码
    Pair<PythonResponse,String> Remote_Python_PriceTagRecognition(MultipartFile imageStream, String url_image) throws IOException;

    Map<String, Object> localImagesBed_Upload(MultipartFile file, String userid);
}
