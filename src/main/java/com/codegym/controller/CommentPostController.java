package com.codegym.controller;


import com.codegym.message.response.ResponseMessage;
import com.codegym.model.Post;
import com.codegym.service.post.PostService;
import com.codegym.service.post.commentpost.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth/comment")
public class CommentPostController {
@Autowired
    PostService postService;
@Autowired
    CommentPostService commentPostService;


    // lay list comment theo id bai post
@GetMapping("/{id}")
public ResponseEntity<?> getListCommentByIdPost(@PathVariable Long id){
    //get list post ra
    Optional<Post> post = postService.findById(id);
    List listcomment = (List) commentPostService.getAllCommentByPost(post.get());
    if(listcomment.isEmpty()) return new ResponseEntity<>(new ResponseMessage("khong co bai post"), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(listcomment,HttpStatus.OK);
}
}