package com.vrushali.creational.singleton;

/*
* Explanation:
It adds a synchronized block to the getInstance() method. This ensures that only one thread can execute the code inside the block at a time.
Pros:
Thread-safe.
Cons:
Performance overhead: The synchronized block adds overhead to every call to getInstance(), even after the instance has been created. This can impact performance.
Still relatively simple, but not the most efficient thread-safe solution.
* */
public class NaiveSingletonMultithreaded {

    private static NaiveSingletonMultithreaded instance;

    private NaiveSingletonMultithreaded() {
        // Private constructor to prevent external instantiation
    }

    public static NaiveSingletonMultithreaded getInstance() {
        if (instance == null) {
            synchronized (NaiveSingletonMultithreaded.class) {
                instance = new NaiveSingletonMultithreaded();
            }
        }
        return instance;
    }

    public void doSomething(){
        System.out.println("NaiveSingletonMultithreaded is doing something..!");
    }
}
