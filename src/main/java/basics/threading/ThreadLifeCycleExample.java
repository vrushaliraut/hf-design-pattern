package basics.threading;

/*
    Key States in Thread.State Enum:
    NEW: Thread created but not started.
    RUNNABLE: Thread is running.
    BLOCKED: Thread is waiting for a monitor lock.
    WAITING: Thread is waiting indefinitely.
    TIMED_WAITING: Thread is waiting for a specified duration.
    TERMINATED: Thread has completed execution.

* */

public class ThreadLifeCycleExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        });

        System.out.println(thread.getState()); // New);
        thread.start();
        System.out.println(thread.getState()); // Runnable);

        try {
            Thread.sleep(2000);  // Allow thread to enter TIMED_WAITING
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }

        System.out.println(thread.getState()); // TimedWaiting);

        thread.join(); // Wait for thread to complete
        System.out.println(thread.getState()); // Terminated);
    }

}
