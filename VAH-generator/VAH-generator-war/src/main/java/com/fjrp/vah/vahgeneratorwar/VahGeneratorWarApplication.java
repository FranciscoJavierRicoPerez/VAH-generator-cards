package com.fjrp.vah.vahgeneratorwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class VahGeneratorWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(VahGeneratorWarApplication.class, args);
	}

}
