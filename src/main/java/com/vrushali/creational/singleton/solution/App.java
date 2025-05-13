package com.vrushali.creational.singleton.solution;

public class App {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            DBConnSingletonUnSafeMultiThread.getDBConnection("Thread1");
        };

        Runnable runnable2 = () -> {
            DBConnSingletonUnSafeMultiThread.getDBConnection("Thread2");
        };

        Thread t1 = new Thread(runnable1);

        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        // thats not singleton anymore
    }
}
