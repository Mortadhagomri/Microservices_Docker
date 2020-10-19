package com.repartis.cmnts;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.repartis.cmnts.entities.Comment;
import com.repartis.cmnts.repositories.CommentRepository;
import com.repartis.cmnts.services.Sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CmntsApplication implements CommandLineRunner{

	@Autowired
	CommentRepository commentrepository;
	@Autowired
	Sequence sequenceGenerator;

	public static void main(String[] args) {
		SpringApplication.run(CmntsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//commentaire.setId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));

		RestTemplate restTemplate = new RestTemplate();
 
		List<Comment> l = Arrays.stream(restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class)).collect(Collectors.toList());
		
		for(int i=0; i<l.size();i++){
			Random random = new Random();
			Long uId = (long) (random.nextInt(10) + 1);
			l.get(i).setUserId(uId);
			l.get(i).setId(sequenceGenerator.generateSequence(Comment.SEQUENCE_NAME));
			commentrepository.save(l.get(i));
		}


	}

}
