package com.testApi.manageCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.testApi.manageCustomer")
public class ManageCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCustomerApplication.class, args);
	}

}
