package com.example.test.Dto;

import com.example.test.Entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {

    private Long commentId;
    private Long memoId;
    private String content;

    public CommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.memoId = comment.getMemo().getMemoId();
        this.content = comment.getContent();
    }
}