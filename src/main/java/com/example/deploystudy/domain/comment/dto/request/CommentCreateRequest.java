package com.example.deploystudy.domain.comment.dto.request;



public record CommentCreateRequest(
        String text,
        Long postId
) {
}
