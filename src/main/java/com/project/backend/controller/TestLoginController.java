package com.project.backend.controller;

import com.project.backend.entity.Account;
import com.project.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestLoginController {
    @Autowired
    SessionService sessionService;
    @GetMapping("/profile")
    public String userProfile(Model model, Account account) {
        String userName = account.getUserName();
        model.addAttribute("isAdmin",sessionService.get("isAdmin"));
        return "loichao";
    }
    @GetMapping("/Login")
    public String login (Model model , Account account){

        return "dangnhap";
    }
    @PostMapping("/Login")
    public String logins (Model model , Account account){
        String username = (String) model.getAttribute("userName");
        String password = (String) model.getAttribute("password");
        Boolean isAdmin = false;
        if(username.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("123")){
            sessionService.set("isAdmin",true);
            return "loichao";
        } else if (username.equalsIgnoreCase("USER") && password.equalsIgnoreCase("123")) {
            sessionService.set("isAdmin",false);
            return "loichao";
        } else {
            return "dangnhap";
        }
    }

}
