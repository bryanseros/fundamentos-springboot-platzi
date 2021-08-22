package com.fundamenosplatzi.springboot.fundamentos;

import com.fundamenosplatzi.springboot.fundamentos.Component.ComponentDependency;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyOperation;
import com.fundamenosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyOperation myOperation;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getPassword() + "-" +userPojo.getAge());
		//myBean.print();
	}
}
