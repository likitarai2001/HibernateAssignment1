package com.example.socialmediaapp.repository;

import com.example.socialmediaapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Integer> {
}
