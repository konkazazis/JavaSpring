package com.example.springboot.blog.controller;

import com.example.springboot.blog.model.BlogPost;
import com.example.springboot.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // Show the form to add a new blog post
    @GetMapping("/add-blogpost")
    public String showBlogPostForm(Model model) {
        model.addAttribute("blogPost", new BlogPost());
        return "add-blogpost";  // This is the Thymeleaf template to show the form
    }

    // Handle form submission to add a blog post
    @PostMapping("/add-blogpost")
    public String addBlogPost(@ModelAttribute BlogPost blogPost) {
        // Set the current time for the blog post's datePublished field
        blogPost.setDatePublished(LocalDateTime.now());
        // Save the blog post to the database
        blogPostService.save(blogPost);
        // Redirect to the page that lists all blog posts
        return "redirect:/blogposts";
    }

    // Show all blog posts
    @GetMapping("/blogposts")
    public String getAllBlogPosts(Model model) {
        // Retrieve the list of all blog posts
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        // Add the blog posts to the model
        model.addAttribute("blogPosts", blogPosts);
        // Return the Thymeleaf template to render the blog posts
        return "blogposts";  // This template will display the blog posts
    }
}
