package com.fundamenosplatzi.springboot.fundamentos.bean;

import org.springframework.stereotype.Component;

@Component
public class MyOperationImplement implements MyOperation{


    @Override
    public int sum(int number) {
        return number + 1;
    }
}
