package com.spandana.post_influx.controller;

import com.spandana.post_influx.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> forwardDigitalAssetOrder(
            @RequestParam String fromEmail,
            @RequestParam String senderName,
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam String theme,
            @RequestParam String customHeading,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        try {
            emailService.dispatchMimeOrder(fromEmail, senderName, to, subject, body, theme, customHeading, file);
            return ResponseEntity.ok("Fulfillment dispatch package routed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}