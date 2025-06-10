package com.abdellah.billingservice.model;

import lombok.*;

/*
Customer is not stored in the database, but instead used only at runtime to:

✅ Temporarily hold customer information retrieved from another microservice (like a customer-service) using the customerId.

✅ Facilitate data enrichment before sending the Bill as a response to the frontend or another service, often in API aggregation patterns.

In short:
👉 customerId is persisted,
👉 customer is transient — just a helper to carry full customer data when needed.
 */

@Getter @Setter
public class Customer {
    private Long id;
    private String name;
    private String email;
}
