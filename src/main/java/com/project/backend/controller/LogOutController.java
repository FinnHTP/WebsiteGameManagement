package com.project.backend.controller;

import com.project.backend.entity.Account;
import com.project.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {
    @Autowired
    SessionService session;
    @GetMapping("/account/logout")
    public String logout(Model model) {
        Account accountLogin = (Account) session.get("username");
        if(accountLogin != null) {
            session.set("username", null);
        }
        return "redirect:/visitor/login";
    }
}
