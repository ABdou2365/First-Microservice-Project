package com.abdellah.customerservice.entities;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigProperties(String x,String y) {
}
