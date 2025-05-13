package basics.threading;

/*1. How Do Immutable Objects Help Prevent Race Conditions?
Technical Definition:
Immutable objects are inherently thread-safe because their state cannot change after creation.
Since multiple threads can safely access and share immutable objects without worrying about concurrent modifications,
 race conditions are eliminated.
Why and How:
A race condition occurs when multiple threads access shared mutable data simultaneously,
leading to unpredictable results due to interleaved read/write operations.
Immutable objects avoid this issue because their state is fixed at construction time, making them safe for concurrent access.

* */

public class ImmutableObjectExample {
    public static void main(String[] args) {
        ImmutableObject object = new ImmutableObject(42);

        // Multiply threads can safely access obj.getValue()
        Runnable task = () -> System.out.println("Value: "+object.getValue());
        new Thread(task).start();
        new Thread(task).start();
    }
}

final class ImmutableObject {
    private final int value;
    public ImmutableObject(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
