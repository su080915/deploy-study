package com.example.deploystudy.domain.post.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {
    private String title;
    private String content;
}
