package basics.threading;

public class ThreadExampleForTermination {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();

        // Interrupt the thread after 5 seconds
        Thread.sleep(5000);
        thread.interrupt();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Simulate work
                System.out.println("Working");
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException exception) {
                // Restore interrupted status and exit
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted, exiting...");
                break;
            }
        }
        // Perform cleanup
        System.out.println("Cleanup completed..");
    }
}