package com.vrushali.creational.singleton.solution;

public class DBConnection {
    private static DBConnection connection;

    private DBConnection(String name) { // constructor is private
        System.out.println("Connection to DB established by " + name);
    }

    public static DBConnection getDBConnection(String name) { // with static method we create instance
        if (connection == null) {
            connection = new DBConnection(name);
        }
        return connection;
    }
}
