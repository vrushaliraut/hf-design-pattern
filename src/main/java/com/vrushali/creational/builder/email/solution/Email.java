package com.vrushali.creational.builder.email.solution;

import java.util.List;

public class Email {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public Email(EmailBuilder emailBuilder) {
        this.to = emailBuilder.getTo();
        this.subject = emailBuilder.getSubject();
        this.body = emailBuilder.getBody();
        this.cc = emailBuilder.getCc();
        this.bcc = emailBuilder.getBcc();
        this.attachments = emailBuilder.getAttachements();
    }


    // Getters only – no setters (immutability)
    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
