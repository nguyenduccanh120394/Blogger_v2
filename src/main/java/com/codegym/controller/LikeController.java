package com.codegym.controller;

import com.codegym.model.Like;
import com.codegym.model.Post;
import com.codegym.service.like.ILikeService;
import com.codegym.service.like.LikeService;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private ILikeService likeService;

    @GetMapping()
    public ResponseEntity<Iterable<Like>> findAll() {
        return new ResponseEntity<>(likeService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Like> create(@RequestBody Like like) {
        return new ResponseEntity<>(likeService.save(like), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Like> delete(@PathVariable Long id) {
        likeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
 @GetMapping("/search/{idUser}/{idPost}")

 public ResponseEntity<Iterable<Like>> findByUserIdAndIdPost(@PathVariable Long idUser,@PathVariable Long idPost){

          return new ResponseEntity<>(likeService.findAllByIdUserAndIdPost(idUser,idPost),HttpStatus.OK);

 }
 @GetMapping("/search/top")
    public ResponseEntity<Iterable<Like>> findTop(){
        return new ResponseEntity<>(likeService.findtop(),HttpStatus.OK);
 }
 @GetMapping("/search/{idPost}")
    public ResponseEntity<Iterable<Like>> findByIdPost(@PathVariable Long idPost){
        return new ResponseEntity<>(likeService.findByIdPost(idPost),HttpStatus.OK);
 }
 }
