package com.abdellah.billingservice.entities;

import com.abdellah.billingservice.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double unitPrice;
    private int quantity;
    @ManyToOne
    /*
    In a bidirectional relationship between Bill and ProductItem, serializing both sides can lead
    to infinite recursion or very large nested JSON.
     */
    // So we need to mentionne this to ignore it during serialization
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    /*
      his means that the product field in the ProductItem entity is not mapped to any column in the database.
      It’s used only at runtime—for example, to temporarily hold product data fetched from another
      microservice or source, like in a microservices architecture.
     */
    @Transient
    private Product product;
}
