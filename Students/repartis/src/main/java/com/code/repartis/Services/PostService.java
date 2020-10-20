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
public class PostService {

    @Autowired
    RestTemplateClass restTemplate;

    public List<Object> getuserposts(Long id){

        List<Object> responseEntity = Arrays.stream(restTemplate.getForObject("http://localhost:4000/getUserPosts/{id}", Object[].class)).collect(Collectors.toList());

        return responseEntity;

    }
    
}
