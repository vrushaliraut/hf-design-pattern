package basics.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableAndCallable {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {

        // Runnable
        Runnable runnableTask = () -> {
            System.out.println("Executing runnable task");
        };

        Thread thread = new Thread(runnableTask);
        thread.start();

        // Callable
        Callable<String> callableTask = () -> {
            return "Executing callable task";
        };

        Future<String> future = Executors.newSingleThreadExecutor().submit(callableTask);
        System.out.println("Result: " + future.get());
    }
}
