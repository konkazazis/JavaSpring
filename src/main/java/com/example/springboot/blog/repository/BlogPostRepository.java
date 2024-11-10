package com.example.springboot.blog.repository;

import com.example.springboot.blog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    // You can add custom queries if needed
}
