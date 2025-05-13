package com.vrushali.creational.singleton.problem;

public class Client2 {
    public void run() {
        CacheManager cache = new CacheManager();
        String value = cache.getFromCache("username");
        System.out.println("Client2 tried to get 'username': " + value);
    }
}