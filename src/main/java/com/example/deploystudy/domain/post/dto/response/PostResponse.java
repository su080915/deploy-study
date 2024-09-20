package com.example.deploystudy.domain.post.dto.response;


import com.example.deploystudy.domain.user.domain.User;
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
    private User author;
    private Long viewCount;
}
