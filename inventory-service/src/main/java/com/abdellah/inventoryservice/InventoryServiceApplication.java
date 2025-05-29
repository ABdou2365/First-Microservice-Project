package com.abdellah.inventoryservice;

import com.abdellah.inventoryservice.entities.Product;
import com.abdellah.inventoryservice.repository.ProductRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Phone")
							.price(100.0)
							.quantity(500)
							.build(),
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Laptop")
							.price(1200.0)
							.quantity(150)
							.build(),
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Headphones")
							.price(80.0)
							.quantity(300)
							.build(),
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Monitor")
							.price(250.0)
							.quantity(100)
							.build(),
					Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Keyboard")
							.price(40.0)
							.quantity(200)
							.build()
			));

			System.out.println("================================");
			productRepository.findAll().forEach(System.out::println);

		};
	}

}
