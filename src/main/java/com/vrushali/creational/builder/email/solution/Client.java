package com.vrushali.creational.builder.email.solution;

public class Client {
    public static void main(String[] args) {
        EmailBuilder builder = new EmailBuilder();
        Email email = builder
                .setTo("contact@org")
                .setSubject("Request for Java Multithreading Content")
                .setBody("Hello, ....")
                .build();
        // email is immutable because it does not have setters and the attributes are private.
        System.out.println(email);
    }
}
