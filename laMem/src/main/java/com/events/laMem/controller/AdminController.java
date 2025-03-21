package com.events.laMem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    
    @GetMapping("/admin_login")
    public String showAdminLoginPage() {
        return "redirect:/admin_login.html";  
    }
    
    @GetMapping("/registerAdmin")
    public String showRegisterAdminPage() {
        return "redirect:/registerAdmin.html"; 
        
    } 
    @PostMapping("/registerAdmin")
    public String handleRegisterAdmin(@RequestParam String username, @RequestParam String password) {
        
        System.out.println("Admin Registered: " + username);
        
        return "redirect:/admin_dashboard.html"; 
    }


    
    @PostMapping("/admin_login")
    public ModelAndView handleAdminLogin(@RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView();
        
        if ("admin".equals(username) && "password".equals(password)) {
            mv.setViewName("redirect:/admin_dashboard.html");  
        } else {
            mv.setViewName("redirect:/admin_login.html");  
            mv.addObject("error", "Invalid username or password");
        }
        
        return mv;
    }
}
