package com.example.test.Dto;

import com.example.test.Entity.Memo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoResponseDto {
    private Long memoId;
    private String title;
    private String content;

    public MemoResponseDto(Memo memo) {
        this.memoId = memo.getMemoId();
        this.title = memo.getTitle();
        this.content = memo.getContent();
    }
}