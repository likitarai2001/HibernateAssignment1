package com.example.socialmediaapp.service;

import com.example.socialmediaapp.entities.Post;

import java.util.List;

public interface PostService {

    public List<Post> getAllPosts();

    public Post addPost(Post post, int id);
}
