package com.abdellah.customerservice;


import com.abdellah.customerservice.entities.Customer;
import com.abdellah.customerservice.entities.CustomerConfigProperties;
import com.abdellah.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigProperties.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository) {
		return args -> {
			repository.save(Customer.builder().name("abdo").email("abdo@gmail.com").build());
			repository.save(Customer.builder().name("reda").email("reda@gmail.com").build());
			repository.save(Customer.builder().name("amine").email("amine@gmail.com").build());
			repository.save(Customer.builder().name("yassine").email("yassine@gmail.com").build());
			System.out.println("===================================");
			repository.findAll().forEach(System.out::println);
		};
	}

}