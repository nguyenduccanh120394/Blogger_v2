package com.codegym.controller;

import com.codegym.message.response.ResponseMessage;
import com.codegym.model.Post;
import com.codegym.service.post.IPostService;
import com.codegym.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/posts")
public class PostController{
    @Autowired
    PostService postService;

    @GetMapping()
    public ResponseEntity<Iterable<Post>> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/public")
    public ResponseEntity<Iterable<Post>> findAllByStatus() {
        return new ResponseEntity<>(postService.findAllByStatus(), HttpStatus.OK);
    }

    // tìm post của user khác chỉ trả về public
    @GetMapping("/search/user/{id}")
    public ResponseEntity<Iterable<Post>> findAllByOtherUser(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findByOtherUser(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody @Valid Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()){
            return new ResponseEntity<>(new ResponseMessage("Không tìm thấy bài post"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()){
            return new ResponseEntity<>(new ResponseMessage("Không tìm thấy bài post"),HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("delete done"),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Post> edit(@RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Iterable<Post>> findByTitle(@PathVariable String title) {

        return new ResponseEntity<>(postService.findAllByTitle(title), HttpStatus.OK);
    }

    // tìm post của user trả về cả public và private
    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<Post>> findAllByIdUser(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findAllByIdUser(id), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}/{hashtagId}")
    public ResponseEntity<Iterable<Post>> findMyPostByHashtag(@PathVariable Long userId, @PathVariable Long hashtagId){
        return new ResponseEntity<>(postService.findMyPostByHashtag(userId, hashtagId),HttpStatus.OK);
    }

    @GetMapping("/search/hashtag/{id}")
    public ResponseEntity<Iterable<Post>> findAllByHashtag(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findAllByHashtagId(id), HttpStatus.OK);
    }

    @GetMapping("/search/date/{top}")
    public ResponseEntity<Iterable<Post>> findTopDate(@PathVariable Long top) {
        return new ResponseEntity<>(postService.findTopByDate(top), HttpStatus.OK);
    }
    @GetMapping("/search/{id}/{title}")
    public ResponseEntity<Iterable<Post>> findMyPostByTitle(@PathVariable Long id,@PathVariable String title) {
        title = "%" + title + "%";
        return new ResponseEntity<>(postService.findMyPostByTitle(id, title), HttpStatus.OK);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Nếu validate fail thì trả về 400
    public ResponseEntity handleBindException(BindException e) {
        // Trả về message của lỗi đầu tiên
        String errorMessage = "Request không hợp lệ";
        if (e.getBindingResult().hasErrors())
            e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity(errorMessage, HttpStatus.OK);
    }


}
