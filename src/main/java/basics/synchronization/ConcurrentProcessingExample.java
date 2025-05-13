package basics.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentProcessingExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.shutdown();
    }
}


