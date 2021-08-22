package com.fundamenosplatzi.springboot.fundamentos.Configuration;

import com.fundamenosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation suma(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency print(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
