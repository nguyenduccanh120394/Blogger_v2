package com.codegym.service.post.commentpost;

import com.codegym.model.CommentPost;
import com.codegym.model.Post;
import com.codegym.repository.ICommentPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentPostService implements ICommentPostSevice{
    @Autowired
    ICommentPostRepository commentPostRepository;
    @Override
    public Iterable<CommentPost> findAll() {
        return null;
    }

    @Override
    public Optional<CommentPost> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CommentPost save(CommentPost commentPost) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
    @Override
    public Iterable<CommentPost> getAllCommentByPost(Post post) {
        return   commentPostRepository.findAllByPost(post);
    }
}
