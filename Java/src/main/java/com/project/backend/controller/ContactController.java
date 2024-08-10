package com.project.backend.controller;

import com.project.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void sendContactForm(@RequestParam String email,@RequestParam String subject,@RequestParam String message) {
        contactService.sendContactForm( email, subject, message);
    }
}
