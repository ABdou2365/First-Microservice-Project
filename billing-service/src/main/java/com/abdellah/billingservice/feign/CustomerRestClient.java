package com.abdellah.billingservice.feign;

import com.abdellah.billingservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{customerId}")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long customerId);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long customerId,Exception e) {
        return Customer.builder()
                .id(customerId)
                .name("defaultUsername")
                .email("default@abdellah.com")
                .build();
    }
}
