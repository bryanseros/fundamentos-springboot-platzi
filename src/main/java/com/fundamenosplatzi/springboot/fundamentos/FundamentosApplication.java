package com.fundamenosplatzi.springboot.fundamentos;

import com.fundamenosplatzi.springboot.fundamentos.Component.ComponentDependency;
import com.fundamenosplatzi.springboot.fundamentos.Repository.UserRepository;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamenosplatzi.springboot.fundamentos.bean.MyOperation;
import com.fundamenosplatzi.springboot.fundamentos.entity.User;
import com.fundamenosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyOperation myOperation;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		saveUsersInDataBase();
		getInformationJpqlFromUser();
		/*componentDependency.saludar();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getPassword() + "-" +userPojo.getAge());*/
		//myBean.print();
	}

	private void getInformationJpqlFromUser(){
		System.out.println(userRepository.findByUserEmail("insert2@insert.com"));

		userRepository.findAndSort("bry", Sort.by("id").descending()).stream().forEach(user -> System.out.println("Usuario con metodo sort" + user));
	}
	private void saveUsersInDataBase(){
		User user1 = new User("Walter", "insert1@insert.com", LocalDate.of(2021, 8,28));
		User user2 = new User("bryanseros1", "insert1@insert.com", LocalDate.of(2021, 2,28));
		User user3 = new User("bryanseros2", "insert1@insert.com", LocalDate.of(2021, 1,28));
		User user4 = new User("bryanseros3", "insert1@insert.com", LocalDate.of(2021, 3,28));
		User user5 = new User("bryanseros4", "insert1@insert.com", LocalDate.of(2021, 4,28));
		User user6 = new User("bryanseros5", "insert1@insert.com", LocalDate.of(2021, 5,28));
		User user7 = new User("bryanseros6", "insert2@insert.com", LocalDate.of(2021, 6,28));
		User user8 = new User("bryanseros7", "insert1@insert.com", LocalDate.of(2021, 7,28));
		User user9 = new User("Dionne", "insert1@insert.com", LocalDate.of(2021, 10,28));
		User user10 = new User("bryanseros9", "insert1@insert.com", LocalDate.of(2021, 9,28));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);

		list.stream().forEach(userRepository::save);
		//System.out.println(userRepository.findAll());
	}

}
