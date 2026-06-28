package com.spandana.post_influx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String loadAuthLandingPortal() {
        return "index"; // Renders index.html
    }

    @GetMapping("/dashboard")
    public String loadAdminDashboardPanel() {
        return "dashboard"; // Renders your working multi-tab sidebar console
    }

    @GetMapping("/track-order")
    public String displayPublicTrackingPage() {
        return "track-order"; // Renders track-order.html
    }
}