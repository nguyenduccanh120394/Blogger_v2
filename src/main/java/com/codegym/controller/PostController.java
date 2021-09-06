package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping()
    public ResponseEntity<Iterable<Post>> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody @Valid Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Post> delete(@PathVariable Long id) {
        postService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Post> edit(@RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
    public ResponseEntity handleBindException(BindException e) {
        // Trả về message của lỗi đầu tiên
        String errorMessage = "Request không hợp lệ";
        if (e.getBindingResult().hasErrors())
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity(errorMessage,HttpStatus.OK) ;
    }
}