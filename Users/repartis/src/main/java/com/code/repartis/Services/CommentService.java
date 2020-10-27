package com.code.repartis.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.code.repartis.Configuration.RestTemplateClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentService {

    @Autowired
    RestTemplateClass restTemplate;

	public List<Object> getUserComments(Long id) {
        List<Object> responseEntity = Arrays.stream(restTemplate.getForObject("http://comments_container:8080/byUserId/"+id, Object[].class, id)).collect(Collectors.toList());
        return responseEntity;
	}
    
}
