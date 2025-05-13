package com.vrushali.creational.singleton.solution;

public class DBConnSingletonUnSafeMultiThread {
    private static DBConnSingletonUnSafeMultiThread connectionSingleton;

    private DBConnSingletonUnSafeMultiThread(String name) {
        System.out.println("Connection to DB is established by " + name);
    }

    public static DBConnSingletonUnSafeMultiThread getDBConnection(String name) {
        if (connectionSingleton == null) {
            // Simulate delay to increase the chance of thread overlap
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connectionSingleton = new DBConnSingletonUnSafeMultiThread(name);
        }
        return connectionSingleton;
    }
}