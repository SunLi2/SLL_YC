package com.zsc.imagesbed.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ImagesHandlerInterceptor()).addPathPatterns("/uploadImages/*")
                .excludePathPatterns("/","/api/*","/index","/login","/css/*","/img/*","/js/*","/uploadImages/*");
    }

}
