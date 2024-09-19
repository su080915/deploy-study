package com.example.deploystudy.domain.post.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
@Builder
public class PostResponse {
    private String id;
    private String title;
    private String content;
    private String author;
    private Long viewCount;
}
