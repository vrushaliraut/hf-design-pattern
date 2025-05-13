package com.vrushali.creational.singleton;

/*
* Explanation:
It uses double-checked locking to reduce the overhead of synchronization.
The volatile keyword is crucial to ensure that the instance variable is properly updated across threads.
Pros:
Thread-safe.
Lazy initialization.
Reduced synchronization overhead compared to the previous approach.
Cons:
More complex to implement.
Can still have subtle issues in some Java versions (though less likely in modern JVMs).
**/

public class ThreadSafeLazyLoadedSingleton {
    private static volatile ThreadSafeLazyLoadedSingleton instance;

    private ThreadSafeLazyLoadedSingleton() {
        // Private constructor to prevent external instantiation
    }

    public static ThreadSafeLazyLoadedSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLazyLoadedSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazyLoadedSingleton();
                }
            }
        }

        return instance;
    }

    public void doSomething() {
        System.out.println("ThreadSafeLazyLoadedSingleton is doing something!");
    }
}
