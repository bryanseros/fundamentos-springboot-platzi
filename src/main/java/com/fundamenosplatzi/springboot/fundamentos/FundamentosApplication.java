package com.fundamenosplatzi.springboot.fundamentos;

import com.fundamenosplatzi.springboot.fundamentos.Component.ComponentDependency;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyOperation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyOperation myOperation;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyOperation myOperation) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myOperation = myOperation;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		componentDependency.saludar();
		//myBean.print();
	}
}
