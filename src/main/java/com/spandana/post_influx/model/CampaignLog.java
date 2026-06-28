package com.spandana.post_influx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "campaign_logs")
public class CampaignLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String senderEmail;
    private String recipient;
    private String subject;
    private String timestamp;
    private String status;

    public CampaignLog() {}

    public CampaignLog(Long userId, String senderEmail, String recipient, String subject, String timestamp, String status) {
        this.userId = userId;
        this.senderEmail = senderEmail;
        this.recipient = recipient;
        this.subject = subject;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getSenderEmail() { return senderEmail; }
    public String getRecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getTimestamp() { return timestamp; }
    public String getStatus() { return status; }
}