package com.example.potserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PotServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotServerApplication.class, args);
    }

}
