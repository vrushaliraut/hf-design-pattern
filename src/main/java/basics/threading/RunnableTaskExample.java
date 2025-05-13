package basics.threading;

public class RunnableTaskExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executing runnable task");
            }
        });
    }
}
