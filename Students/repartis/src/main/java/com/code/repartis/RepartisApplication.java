package com.code.repartis;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import com.code.repartis.entities.User;
import com.code.repartis.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RepartisApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RepartisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
 
		List<User> l = Arrays.stream(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class)).collect(Collectors.toList());
		
		for(int i=0; i<l.size();i++){
				userRepository.save(l.get(i));
		}
	}

}


