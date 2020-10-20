package com.code.repartis.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.code.repartis.entities.User;
import com.code.repartis.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataBase {

    @Autowired
	UserRepository userRepository;

	public void filldb() {
        
        RestTemplate restTemplate = new RestTemplate();
 
		List<User> l = Arrays.stream(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class)).collect(Collectors.toList());
		
		for(int i=0; i<l.size();i++){
				userRepository.save(l.get(i));
		}

	}


    
}
