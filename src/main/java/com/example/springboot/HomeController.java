package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // You can add attributes to the model here if needed
        return "index";  // This corresponds to src/main/resources/templates/index.html
    }
}
