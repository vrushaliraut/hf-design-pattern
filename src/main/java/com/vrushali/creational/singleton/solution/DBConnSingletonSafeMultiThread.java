package com.vrushali.creational.singleton.solution;

/*
Synchronises the method every time, even when the object is already created,
 that can slows things down
* */

public class DBConnSingletonSafeMultiThread {
    private static DBConnSingletonSafeMultiThread connection;

    private DBConnSingletonSafeMultiThread(String name) {
        System.out.println("Connection to DB is established by " + name);
    }

    public static synchronized DBConnSingletonSafeMultiThread getDBConnection(String name) {
        if (connection == null) {
            connection = new DBConnSingletonSafeMultiThread(name);
        }
        return connection;
    }
}
