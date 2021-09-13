package com.codegym.controller;

import com.codegym.model.Like;
import com.codegym.model.Post;
import com.codegym.model.User;
import com.codegym.service.like.ILikeService;
import com.codegym.service.like.LikeService;
import com.codegym.service.post.IPostService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private ILikeService likeService;
    @Autowired
    private IPostService postService;
@Autowired
private UserService userService;
    @GetMapping()
    public ResponseEntity<Iterable<Like>> findAll() {
        return new ResponseEntity<>(likeService.findAll(), HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Like> delete(@PathVariable Long id) {
        likeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{idUser}/{idPost}")

    public ResponseEntity<Like> findByUserIdAndIdPost(@PathVariable Long idUser, @PathVariable Long idPost) {

        return new ResponseEntity<>(likeService.findByIdUserAndIdPost(idUser, idPost).get(), HttpStatus.OK);

    }

    @GetMapping("/search/top")
    public ResponseEntity<Iterable<Like>> findTop() {
        return new ResponseEntity<>(likeService.findtop(), HttpStatus.OK);
    }

    @GetMapping("/search/{idPost}")
    public ResponseEntity<Iterable<Like>> findByIdPost(@PathVariable Long idPost) {
        return new ResponseEntity<>(likeService.findByIdPost(idPost), HttpStatus.OK);
    }
            @GetMapping("/search/top5")
            public ResponseEntity<Iterable<Like>> findTop5(){
                return new ResponseEntity<>(likeService.findTop5(),HttpStatus.OK);
            }

}

