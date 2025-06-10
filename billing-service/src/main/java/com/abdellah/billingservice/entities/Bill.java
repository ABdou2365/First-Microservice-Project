package com.abdellah.billingservice.entities;

import com.abdellah.billingservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    /*
      his means that the customer field in the Bill entity is not mapped to any column in the database.
      It’s used only at runtime—for example, to temporarily hold customer data fetched from another
      microservice or source, like in a microservices architecture.
     */
    @Transient
    private Customer customer;

}

