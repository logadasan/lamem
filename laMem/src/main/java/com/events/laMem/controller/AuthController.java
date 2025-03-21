 package com.events.laMem.controller;



import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.events.laMem.model.User;
import com.events.laMem.service.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful! Please login.");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        return userService.findByUsername(username).filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    session.setAttribute("user", user);
                    return "redirect:/home"; 
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid username or password.");
                    return "login";
                });
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}

