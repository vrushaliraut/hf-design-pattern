package com.vrushali.creational.singleton;

/*
* Why is the Singleton Pattern Used in Java?
The Singleton pattern is used (though often with caution) in Java for these reasons:

Controlled Access to a Shared Resource: When you need to manage access to a resource that should only have one instance
* (e.g., a database connection, a logger, a configuration manager).
Saving System Resources: When creating multiple instances of a class would consume excessive resources (e.g., memory, file handles).
Global Point of Access: When you need a single, easily accessible point to access a particular service or object.
Problems Associated with the Singleton Pattern
It's crucial to acknowledge the problems that often accompany the Singleton pattern:

Global State: Singletons often introduce global state into an application, making it harder to reason about and test.
Tight Coupling: Singletons can create tight coupling between different parts of the application, making it difficult to modify or reuse code.
Testing Difficulties: It can be challenging to test code that uses Singletons because you can't easily replace them with mock objects.
Concurrency Issues: Implementing thread-safe Singletons can be complex and prone to errors.
Violation of SRP: It can violate the Single Responsibility Principle,
* as the Singleton class is responsible for its own logic and also for its own instantiation.
* */


/*
Explanation:
The constructor is private, preventing direct instantiation.
        The getInstance() method provides the global access point.
It uses lazy initialization: the instance is created only when getInstance() is called for the first time.
        Pros:
Simple to implement.
Lazy initialization.
Cons:
Not thread-safe: In a multithreaded environment, multiple threads could enter the if (instance == null) block simultaneously
and create multiple instances
*/
public class NaiveSingleton  { // Single Threaded
    private static NaiveSingleton instance; // static singleton pattern

    public NaiveSingleton() {
        // private constructor to prevent external instantiation
    }

    public static NaiveSingleton getInstance() {
        if (instance == null) {
            instance = new NaiveSingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("NaiveSingleton is doing something..!");
    }

    public static void main(String[] args) {
        NaiveSingleton singleton1 = NaiveSingleton.getInstance();
        NaiveSingleton singleton2 = NaiveSingleton.getInstance();

        System.out.println(singleton1 == singleton2); // true
        singleton1.doSomething();
    }
}
