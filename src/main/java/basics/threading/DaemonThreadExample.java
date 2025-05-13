package basics.threading;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        daemonThread.setDaemon(true); // Mark as daemon
        daemonThread.start();

        // Main thread exists after 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Main thread exiting...");
    }
}
