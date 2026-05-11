package com.pichincha.dm.cura.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Boots the customer microservice application context, enabling component scanning, auto-configuration, and runtime initialization required to expose HTTP endpoints and support service execution.
 */
@SpringBootApplication
public class AysMsaDmCuraCrCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AysMsaDmCuraCrCustomerApplication.class, args);
	}

}