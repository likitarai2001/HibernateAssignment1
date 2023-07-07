package com.example.socialmediaapp.controller;

import com.example.socialmediaapp.entities.Post;
import com.example.socialmediaapp.service.Impl.PostServiceImpl;
import com.example.socialmediaapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllPosts(){
        List<Post> postList = postService.getAllPosts();
        if(postList.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no posts");
        }
        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addPost(@RequestBody Post post, @PathVariable("id") int id){
        Post new_post = postService.addPost(post, id);
        if(new_post == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Object is empty");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Post added successfully");
    }
}
