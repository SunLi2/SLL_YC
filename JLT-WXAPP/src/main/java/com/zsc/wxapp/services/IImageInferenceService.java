package com.zsc.wxapp.services;

import com.zsc.wxapp.entity.PythonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface IImageInferenceService {
    PythonResponse performInferenceOnImageStream(InputStream imageStream) throws IOException;
}
