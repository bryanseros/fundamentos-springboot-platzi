package com.fundamenosplatzi.springboot.fundamentos;

import com.fundamenosplatzi.springboot.fundamentos.Component.ComponentDependency;
import com.fundamenosplatzi.springboot.fundamentos.Repository.UserRepository;
import com.fundamenosplatzi.springboot.fundamentos.Service.UserService;
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
	private UserService userService;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository, UserService userService) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		saveUsersInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
		/*componentDependency.saludar();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getPassword() + "-" +userPojo.getAge());*/
		//myBean.print();
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1","TestTransactional1@domain.com",LocalDate.now());
		User test2 = new User("TestTransactional2","TestTransactional2@domain.com",LocalDate.now());
		User test3 = new User("TestTransactional1","TestTransactional1@domain.com",LocalDate.now());
		User test4 = new User("TestTransactional4","TestTransactional4@domain.com",LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);

		try {
			userService.saveTransactional(users);
		}catch (Exception e){
			System.out.println("Esta es una exception dentro del metodo transaccional " + e);
		}

		userService.getAllUsers().stream()
		.forEach(user -> System.out.println("este es el usuario entro del metodo transaccional " + user));
	}
	private void getInformationJpqlFromUser(){
		System.out.println(userRepository.findByUserEmail("insert2@insert.com"));

		userRepository.findAndSort("bry", Sort.by("id").descending()).stream().forEach(user -> System.out.println("Usuario con metodo sort" + user));

		userRepository.findByName("Dionne")
        .stream()
        .forEach(user -> System.out.println("Usuario con query method " + user));

		System.out.println("Usuario encontrado con query method findByEmailAndName " + userRepository.findByEmailAndName("insert@insert.com","Walter")
		.orElseThrow(()-> new RuntimeException("Usuario no encontrado")));

		userRepository.findByNameLike("%b%")
				.stream()
				.forEach(user -> System.out.println("Usuario findByNameLike " + user));

		userRepository.findByNameOrEmail("Dionne","insert3@insert.com")
				.stream()
				.forEach(user -> System.out.println("Usuario findByNameOrEmail " + user));

		userRepository.findByBirthdayBetween(LocalDate.of(2021,04,28), LocalDate.of(2021,9,28))
		.stream()
		.forEach(user -> System.out.println("Usuario con intervalo de fechas " + user));

		userRepository.findByNameLikeOrderByIdDesc("%bryan%")
				.stream()
				.forEach(user -> System.out.println("Usuario encontrado con findByNameLikeOrderByIdDesc " + user));

		userRepository.findByNameContainingOrderByIdDesc("Walter")
				.stream()
				.forEach(user -> System.out.println("Usuario encontrado con findByNameContainingOrderByIdDesc " + user));

		System.out.println( "El usuario a partir del named paramater es: " + userRepository.getAllByBirthdayAndEmail(LocalDate.of(2021, 8,28), "insert@insert.com")
				.orElseThrow(()-> new RuntimeException("No se encontro usuario por param")));
	}
	private void saveUsersInDataBase(){
		User user1 = new User("Walter", "insert@insert.com", LocalDate.of(2021, 8,28));
		User user2 = new User("bryanseros1", "insert1@insert.com", LocalDate.of(2021, 2,28));
		User user3 = new User("bryanseros2", "insert2@insert.com", LocalDate.of(2021, 1,28));
		User user4 = new User("bryanseros3", "insert3@insert.com", LocalDate.of(2021, 3,28));
		User user5 = new User("bryanseros4", "insert4@insert.com", LocalDate.of(2021, 4,28));
		User user6 = new User("bryanseros5", "insert5@insert.com", LocalDate.of(2021, 5,28));
		User user7 = new User("bryanseros6", "insert6@insert.com", LocalDate.of(2021, 6,28));
		User user8 = new User("bryanseros7", "insert7@insert.com", LocalDate.of(2021, 7,28));
		User user9 = new User("Dionne", "insert9@insert.com", LocalDate.of(2021, 10,28));
		User user10 = new User("bryanseros9", "insert8@insert.com", LocalDate.of(2021, 9,28));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);

		list.stream().forEach(userRepository::save);
		//System.out.println(userRepository.findAll());
	}

}
