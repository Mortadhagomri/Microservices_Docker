package com.cmnts.repartis.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.cmnts.repartis.entities.Comment;
import com.cmnts.repartis.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FillDataBase {

    @Autowired
	CommentRepository commentrepository;

	//@Autowired
    //Sequence sequenceGenerator;
    
    public void filldb(){

    RestTemplate restTemplate = new RestTemplate();
 
		List<Comment> l = Arrays.stream(restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class)).collect(Collectors.toList());
		

		for(int i=0; i<l.size();i++){
			Random random = new Random();
			Long uId = (long) (random.nextInt(10) + 1);
			l.get(i).setUserId(uId);
			//l.get(i).setId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));
			commentrepository.save(l.get(i));
		}
    
    }

}
