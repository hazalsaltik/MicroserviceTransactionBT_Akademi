package com.bt_akademi.transaction_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MicroserviceTransactionBtAkademiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTransactionBtAkademiApplication.class, args);
	}

}
