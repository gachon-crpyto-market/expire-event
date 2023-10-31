package com.gachon.crpytomarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CrpytoMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrpytoMarketApplication.class, args);
	}

}
