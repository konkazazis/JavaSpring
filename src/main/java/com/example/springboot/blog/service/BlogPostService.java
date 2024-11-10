package com.example.springboot.blog.service;

import com.example.springboot.blog.model.BlogPost;
import com.example.springboot.blog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // This annotation indicates that this class is a service component
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    // Method to save a new blog post
    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);  // Save blog post to the database
    }

    // Method to retrieve all blog posts from the database
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();  // Get all blog posts
    }

    // Optional: Method to find a blog post by its ID
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);  // Find by ID, or return null if not found
    }
}
