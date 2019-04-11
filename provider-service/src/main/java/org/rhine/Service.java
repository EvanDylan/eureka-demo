package org.rhine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * service
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class Service {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Service.class);
    }

    @RequestMapping("hello")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("consumer")
    public String consumer() {
        return restTemplate.getForObject("http://service-provider/hello", String.class);
    }
}
