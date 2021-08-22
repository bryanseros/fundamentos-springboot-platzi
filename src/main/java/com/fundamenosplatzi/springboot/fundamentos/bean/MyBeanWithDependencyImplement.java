package com.fundamenosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 3;
        System.out.println("el resultado es: " + myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
