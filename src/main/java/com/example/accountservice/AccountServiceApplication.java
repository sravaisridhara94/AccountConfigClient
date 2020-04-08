package com.example.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Account Service Starter
 * @author  Mounika
 * @version 1.0
 * @since   2020-08-04
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class AccountServiceApplication {
	public static void main(String[] args) {

		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
