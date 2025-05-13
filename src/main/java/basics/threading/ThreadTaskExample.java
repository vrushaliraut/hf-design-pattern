package basics.threading;

class ThreadTask extends Thread {
    public void run() {
        System.out.println("Executing thread task");
    }
}

public class ThreadTaskExample {
    public static void main(String[] args) {
        Thread thread = new ThreadTask();
        thread.start();
    }
}