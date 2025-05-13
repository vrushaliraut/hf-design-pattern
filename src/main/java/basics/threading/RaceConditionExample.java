package basics.threading;

/*
Why Does a Race Condition May Produce Unpredictable Results?
Technical Definition:
A race condition produces unpredictable results because the outcome depends on the order and timing of thread execution,
 which cannot be controlled or predicted in a multi-threaded environment.
Why and How:
When multiple threads access and modify shared mutable data concurrently,
the interleaving of read/write operations can lead to inconsistent or unexpected states.
For example, one thread may overwrite another thread's changes,
or partial updates may be visible to other threads.

* */
class Counter {
    private int value = 0;
    /*public synchronized void increment() {
        value++;
    }*/

    public void increment() {
        value++; // non Atomic operation
    }

    public int getValue() {
        return value;
    }
}

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Counter value: " + counter.getValue());
    }
}
