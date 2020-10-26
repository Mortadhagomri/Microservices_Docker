package com.cmnts.repartis.entities;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.mongodb.lang.Nullable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

    // @Transient
   // public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;

    private Long postId;

    @Nullable
    private Long userId;

    private String name;

    @Email
    @NotEmpty(message = "Email field must not be empty")
    private String email;

    private String body;
    
}
