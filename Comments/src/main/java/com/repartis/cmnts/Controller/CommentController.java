package com.repartis.cmnts.Controller;

import java.util.List;
import java.util.Optional;

import com.repartis.cmnts.entities.Comment;
import com.repartis.cmnts.repositories.CommentRepository;
import com.repartis.cmnts.services.FillDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    private FillDataBase fillService;

    @GetMapping("/fill-comments")
    public ResponseEntity<Long> filldatabase(){
        fillService.filldb();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listComments")
    public List<Comment> listComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/comment-id/{id}")
    public Optional<Comment> getComment(@PathVariable Long id) {
        return commentRepository.findById(id);
    }

    @PostMapping("/saveComment")
    public Comment save(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    @PutMapping(value="/updateComment/{id}")
    public Comment update(@PathVariable Long id,@RequestBody Comment comment){
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @DeleteMapping(value="/delComment/{id}")
        public ResponseEntity<Long> deleteComment(@PathVariable Long id){
            commentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/del-all")
        public ResponseEntity<Long> deleteComment(){
            commentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/comments-by-uid/{id}")
        public List<Comment> getUserComments(@PathVariable Long id){
        return commentRepository.findByUserId(id);
    }

    @GetMapping(value="/comments-by-postid/{id}")
        public List<Comment> getPostComments(@PathVariable Long id){
        return commentRepository.findByPostId(id);
    }

}
