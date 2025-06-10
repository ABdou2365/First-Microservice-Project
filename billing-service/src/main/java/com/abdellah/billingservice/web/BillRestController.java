package com.abdellah.billingservice.web;

import com.abdellah.billingservice.entities.Bill;
import com.abdellah.billingservice.feign.CustomerRestClient;
import com.abdellah.billingservice.feign.ProductRestClient;
import com.abdellah.billingservice.repositories.BillRepository;
import com.abdellah.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bill/{customerId}")
    public Bill getBill(@PathVariable Long customerId) {
        Bill bill = billRepository.findById(customerId).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem ->
                productItem.setProduct(productRestClient.getProductById(productItem.getProductId()))
        );
        return bill;
    }

}
