package com.codegym.repository;

import com.codegym.model.CommentPost;
import com.codegym.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentPostRepository extends JpaRepository {
    Iterable<CommentPost> findAllByPost(Post post);
}
