package com.newt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.mangofactory.swagger.plugin.EnableSwagger;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication 
//@EnableDiscoveryClient 
@EnableSwagger2 
public class OrderProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessingServiceApplication.class, args);
	}
}
