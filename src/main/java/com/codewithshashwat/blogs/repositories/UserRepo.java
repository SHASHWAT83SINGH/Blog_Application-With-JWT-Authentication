package com.codewithshashwat.blogs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithshashwat.blogs.entities.User;
import java.util.List;


public interface UserRepo  extends JpaRepository<User, Integer>{
Optional<User> findByEmail(String email);
}
