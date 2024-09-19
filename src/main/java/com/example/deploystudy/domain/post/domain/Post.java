package com.example.deploystudy.domain.post.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "posts")
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private String author;

    @Setter
    private Long viewCount;
}
