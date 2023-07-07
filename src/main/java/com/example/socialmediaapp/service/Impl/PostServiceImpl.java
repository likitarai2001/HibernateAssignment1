package com.example.socialmediaapp.service.Impl;

import com.example.socialmediaapp.entities.Post;
import com.example.socialmediaapp.entities.User;
import com.example.socialmediaapp.repository.PostRespository;
import com.example.socialmediaapp.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRespository postRespository;

    public List<Post> getAllPosts(){
        List<Post> postList = postRespository.findAll();
        log.info("Post loaded successfully");
        return postList;
    }

    @Override
    public Post addPost(Post post, int id) {
        post.setUser(User.builder()
                .userId(id).build());
        Post savedPost = postRespository.save(post);
        log.info("Post saved successfully");
        return savedPost;
    }

}
