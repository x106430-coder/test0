package com.example.test.Dto;

import com.example.test.Entity.Comment;
import com.example.test.Entity.Memo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private String content;

    public Comment toEntity(Memo memo) {
        return Comment.builder()
                .content(content)
                .memo(memo)
                .build();
    }
}
