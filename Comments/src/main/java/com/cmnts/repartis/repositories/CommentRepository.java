package com.cmnts.repartis.repositories;

import java.util.List;

import com.cmnts.repartis.entities.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, Long>{

	List<Comment> findByUserId(Long userId);

	List<Comment> findByPostId(Long postId);
	
}
