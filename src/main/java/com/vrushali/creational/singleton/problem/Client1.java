package com.vrushali.creational.singleton.problem;

public class Client1 {
    public void run() {
        CacheManager cache = new CacheManager();
        cache.addToCache("username", "vrushali");
        System.out.println("Client1 added key: username -> vrushali");
    }
}