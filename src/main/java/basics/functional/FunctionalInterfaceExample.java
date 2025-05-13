package basics.functional;

import com.vrushali.hf.dp.abstraction.Shark;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface // Enabling Functional programming in java
interface MyFunction {
    void apply(int a, int b);

    static int multiply(int a, int b) {
        return a * b;
    }
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunction add = (x, y) -> System.out.println(x + y);


        add.apply(4, 6);

        System.out.println("Multiplication of 4 and 4 is " + MyFunction.multiply(4, 4));

        Function<Integer, Integer> doubleValue = a -> a * 2;
        doubleValue.andThen(a -> a + 2);
        var addDouble = doubleValue.compose(doubleValue);
        System.out.println(addDouble.apply(2));
        System.out.println(doubleValue.apply(2));

        Predicate<Integer> isEven = a -> a % 2 == 0;
        System.out.println(isEven.test(2));

        Predicate<Integer> isOdd = a -> a % 2 != 0;
        System.out.println(isOdd.test(2));

        // printing, logging, modifying
        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("hello");


        Consumer<Shark> sharkConsumer = s -> s.setColor("red");
        sharkConsumer.accept(new Shark("Shark", "red"));

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(isEven);

    }
}
