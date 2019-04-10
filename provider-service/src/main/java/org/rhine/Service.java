package org.rhine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * service
 */
@EnableEurekaClient
@SpringBootApplication
public class Service {
    public static void main(String[] args) {
        SpringApplication.run(Service.class);
    }
}
