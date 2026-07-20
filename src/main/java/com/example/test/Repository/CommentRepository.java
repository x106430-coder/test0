package com.example.test.Repository;

import com.example.test.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByMemo_MemoIdOrderByCommentIdDesc(Long memoId);
}