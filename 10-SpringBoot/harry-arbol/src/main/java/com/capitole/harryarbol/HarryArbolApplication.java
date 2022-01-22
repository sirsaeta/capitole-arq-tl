package com.capitole.harryarbol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HarryArbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarryArbolApplication.class, args);
	}

}
