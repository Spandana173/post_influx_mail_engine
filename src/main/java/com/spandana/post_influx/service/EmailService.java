package com.spandana.post_influx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void dispatchMimeOrder(String fromEmail, String senderName, String to, String subject, String bodyText, String theme, String customHeading, MultipartFile file) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(fromEmail, senderName);

        String bgGradient, primaryAccent, textPalette, scenicFeatureHTML;

        if ("mountain".equalsIgnoreCase(theme)) {
            bgGradient = "linear-gradient(135deg, #1e1b4b 0%, #311042 50%, #be123c 100%)";
            primaryAccent = "#f43f5e";
            textPalette = "#ffe4e6";
            scenicFeatureHTML = "<div style='text-align:center; font-size:48px; margin-bottom:10px;'>🏔️🌅</div>";
        } else if ("ocean".equalsIgnoreCase(theme)) {
            bgGradient = "linear-gradient(180deg, #0c4a6e 0%, #0284c7 100%)";
            primaryAccent = "#38bdf8";
            textPalette = "#e0f2fe";
            scenicFeatureHTML = "<div style='text-align:center; font-size:48px; margin-bottom:10px;'>🌊⚓</div>";
        } else {
            bgGradient = "linear-gradient(135deg, #0f172a 0%, #022c22 60%, #047857 100%)";
            primaryAccent = "#10b981";
            textPalette = "#ccfbf1";
            scenicFeatureHTML = "<div style='text-align:center; font-size:48px; margin-bottom:10px;'>🌌✨</div>";
        }

        String beautifulHtmlLayout =
                "<div style='background: " + bgGradient + "; padding: 50px 20px; font-family: \"Segoe UI\", Helvetica, sans-serif; min-height: 100%;'>" +
                        "<div style='max-width: 550px; background: rgba(15, 23, 42, 0.85); border: 1px solid rgba(255,255,255,0.1); border-radius: 16px; padding: 40px; margin: 0 auto; box-shadow: 0 20px 25px -5px rgba(0,0,0,0.4); text-align: left;'>" +
                        scenicFeatureHTML +
                        "<h2 style='color: #ffffff; font-size: 24px; margin-top: 10px; border-bottom: 2px solid " + primaryAccent + "; padding-bottom: 15px;'>" + customHeading + "</h2>" +
                        "<p style='color: #e2e8f0; font-size: 15px; line-height: 1.6; margin-top: 20px;'>" + bodyText + "</p>" +
                        "<div style='margin-top: 35px; padding: 20px; background: rgba(255,255,255,0.05); border-left: 4px solid " + primaryAccent + "; border-radius: 6px;'>" +
                        "<span style='display: block; color: " + primaryAccent + "; font-size: 11px; font-weight: bold; text-transform: uppercase;'>Security Verification Node</span>" +
                        "<span style='color: #ffffff; font-size: 13px; font-family: monospace;'>AXIS-NODE-PASSED-" + System.currentTimeMillis() % 100000 + "</span>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

        helper.setText(beautifulHtmlLayout, true);

        if (file != null && !file.isEmpty()) {
            helper.addAttachment(file.getOriginalFilename(), file);
        }

        mailSender.send(mimeMessage);
    }
}