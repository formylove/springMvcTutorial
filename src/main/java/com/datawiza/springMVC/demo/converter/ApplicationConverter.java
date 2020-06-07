package com.datawiza.springMVC.demo.converter;

import com.datawiza.springMVC.demo.bean.Application;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


//parameter
//body HttpMessageConverter
@Component
public class ApplicationConverter implements Converter<String, Application> {
    @Override
    public Application convert(String source) {
        String[] split = source.split("-");
        Application application = new Application();
        application.setName(split[0]);
        application.setDomain(split[1]);
        application.setStatus(Boolean.valueOf(split[2]));
        return application;
    }
}
