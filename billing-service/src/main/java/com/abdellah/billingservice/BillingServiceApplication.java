package com.abdellah.billingservice;

import com.abdellah.billingservice.entities.Bill;
import com.abdellah.billingservice.entities.ProductItem;
import com.abdellah.billingservice.feign.CustomerRestClient;
import com.abdellah.billingservice.feign.ProductRestClient;
import com.abdellah.billingservice.model.Customer;
import com.abdellah.billingservice.model.Product;
import com.abdellah.billingservice.repositories.BillRepository;
import com.abdellah.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient,
										ProductRestClient productRestClient) {
		return args -> {
			Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
			Collection<Product> products = productRestClient.getProducts().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customer(customer)
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.bill(bill)
							.product(product)
							.productId(product.getId())
							.unitPrice(product.getPrice())
							.quantity((int) (1 + Math.random() * 8))
							.build();
					productItemRepository.save(productItem);
				});
			});
		};
	}

}
