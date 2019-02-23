package com.certificate.Taekwondo.configuration;

import com.certificate.Taekwondo.interceptor.LoginRequredInterceptor;
import com.certificate.Taekwondo.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

@Component
public class TkdWebConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    PassportInterceptor passportInterceptor;

    @Autowired
    LoginRequredInterceptor loginRequredInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequredInterceptor).addPathPatterns("/admin/*");
        super.addInterceptors(registry);
    }
}

//@Component
//public class TkdWebConfiguration extends WebMvcConfigurerAdapter {
//    @Autowired
//    PassportInterceptor passportInterceptor;
//
//    @Autowired
//    LoginRequredInterceptor loginRequredInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(passportInterceptor);
//        registry.addInterceptor(loginRequredInterceptor).addPathPatterns("/admin/*");
//        super.addInterceptors(registry);
//    }
//}

