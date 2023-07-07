package com.example.socialmediaapp.repository;

import com.example.socialmediaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
