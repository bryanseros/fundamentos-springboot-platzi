package com.fundamenosplatzi.springboot.fundamentos.Configuration;

import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplements;
import com.fundamenosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(UserPojo.class)
@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplements(name, apellido);
    }
}
