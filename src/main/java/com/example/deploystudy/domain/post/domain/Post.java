package com.example.deploystudy.domain.post.domain;


import com.example.deploystudy.domain.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @Setter
    private String title;

    @Setter
    private String content;

    @ManyToOne
    private User author;

    @Setter
    private Long viewCount;
}
