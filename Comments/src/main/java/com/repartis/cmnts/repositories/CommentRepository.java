package com.repartis.cmnts.repositories;

import java.util.List;

import com.repartis.cmnts.entities.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, Long>{

	List<Comment> findByUserId(Long userId);
    
}
