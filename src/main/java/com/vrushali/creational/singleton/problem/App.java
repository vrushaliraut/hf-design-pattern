package com.vrushali.creational.singleton.problem;

/*
* client1 is adding data to cache
* client2 is trying to retrieve it - but fails
*
* - that's because both clients are using separate instance of CacheManager.
* So the cache data isn't being shared and that defeats the whole purpose of having common cache.
 * */

/* 1. Inconsistent state for shared resources
*  - This is why we need Singleton. When resources like caches, thread pools, loggers or
* - configuration managers are meant to be shared, using multiple instances
* leads to bugs and confusion.
*
* 2. Higher object creation cost
*   - Reading from a disk
*   - Opening network connection
*   - Initializing large in-memory data structures
*   - creating such a object again and agina in different parts of system
* - slows things down and waste resources
*
* 3. Unnecessary Memory Usage
*   - Everytime you create a new Object, it takes up a memory
* */
public class App {
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        Client2 client2 = new Client2();

        client1.run(); // Adds to its own cache
        client2.run(); // Tries to read from different cache
    }
}
