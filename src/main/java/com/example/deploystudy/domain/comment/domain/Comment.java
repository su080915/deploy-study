package com.example.deploystudy.domain.comment.domain;


import com.example.deploystudy.domain.post.domain.Post;
import com.example.deploystudy.domain.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private User author;

    @ManyToOne
    private Post post;
}
