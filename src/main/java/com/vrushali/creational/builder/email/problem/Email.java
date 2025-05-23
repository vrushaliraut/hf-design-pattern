package com.vrushali.creational.builder.email.problem;

import java.util.List;

public class Email {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public Email(String to, String subject, String body, String cc, String bcc,
                 List<String> attachments) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.attachments = attachments;
    }

    // some might prefer just subject and body
    public Email(String to, String subject, String body) {
        //...
    }

    // some might prefer subject, body and cc
    public Email(String to, String subject, String body, String cc) {
        //...
    }

    // some might prefer subject, body, cc and attachments
    public Email(String to, String subject, String body, String cc, List<String> attachments) {
        //...
    }

    // some might prefer subject, body, attachments but not cc
    public Email(String to, String subject, String body, List<String> attachments) {
        //...
    }
    //... more permutations and combinations

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
}

/* No one can modify emal once created but issues are
- Passing null values
- Constructor overload - too many constructors
- Constructor explosions
* */