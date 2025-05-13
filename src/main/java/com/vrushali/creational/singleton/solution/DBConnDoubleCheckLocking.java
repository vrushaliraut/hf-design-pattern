package com.vrushali.creational.singleton.solution;

/*
* First check - Outside synchronized - avoids locking unnecessarily
* Second check - inside synchronized - ensures only one thread creates the object
* Volatile - Threads often cache variable so Thread 1 create object but
* thread 2 still see connection null coz not updated cache
* 2. or half-constructor object
* Volatile - ensure prevention of thread caching and reordering, ensure every thread sees the most up-to-date
*  and fully initialized object
* */
// https://nailyourinterview.org/interview-resources/low-level-design/creational-design-patterns/singleton
public class DBConnDoubleCheckLocking {
    private static volatile DBConnDoubleCheckLocking connection;

    private DBConnDoubleCheckLocking(String name) {
        System.out.println("Connection to DB is established by " + name);
    }

    public static DBConnDoubleCheckLocking getDbConnection(String name) {
        if (connection == null) { // First check (no locking)
            synchronized (DBConnDoubleCheckLocking.class) {
                if (connection == null) { // second check with lock
                    connection = new DBConnDoubleCheckLocking(name);
                }
            }
        }
        return connection;
    }
}
