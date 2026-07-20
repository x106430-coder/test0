package com.example.test.Service;

import com.example.test.Dto.CommentRequestDto;
import com.example.test.Entity.Comment;
import com.example.test.Entity.Memo;
import com.example.test.Repository.CommentRepository;
import com.example.test.Repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemoRepository memoRepository;

    public Comment createComment(Long memoId, CommentRequestDto request) {
        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메모가 존재하지 않습니다."));

        Comment comment = request.toEntity(memo);

        return commentRepository.save(comment);
    }

    public List<Comment> getComments(Long memoId) {
        memoRepository.findById(memoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메모가 존재하지 않습니다."));

        return commentRepository.findByMemo_MemoIdOrderByCommentIdDesc(memoId);
    }

    public Comment updateComment(Long commentId, CommentRequestDto request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다."));

        comment.setContent(request.getContent());

        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);
    }
}
