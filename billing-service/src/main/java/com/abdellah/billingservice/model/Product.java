package com.abdellah.billingservice.model;

import lombok.Getter;
import lombok.Setter;

/*
Product is not stored in the database, but instead used only at runtime to:

✅ Temporarily hold product information retrieved from another microservice (like a inventory-service) using the productId.

✅ Facilitate data enrichment before sending the ProductItem as a response to the frontend or another service, often in API aggregation patterns.

 */


@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
