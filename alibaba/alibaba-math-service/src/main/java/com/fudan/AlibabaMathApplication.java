package com.fudan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaMathApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaMathApplication.class, args);
    }
}
