package com.cmnts.repartis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RepartisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RepartisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	

	}

}
