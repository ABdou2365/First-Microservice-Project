package com.abdellah.customerservice.config;

import com.abdellah.customerservice.entities.CustomerConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {

    @Value("${global.params.p1}")
    private String p1;

    @Value("${global.params.p2}")
    private String p2;

    // First methode
    @GetMapping("/configTest")
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }

    //Seconde methode
    @GetMapping("/configTest2")
    public CustomerConfigProperties getCustomerConfigProperties() {
        return  new CustomerConfigProperties(p1,p2);
    }
}
