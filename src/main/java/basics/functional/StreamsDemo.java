package basics.functional;

import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = 0;
        for (Integer number : list) {
            if (number % 2 == 0) {
                sum = sum + (number * number);
            }

        }
        System.out.println(sum);

        int addition = list.stream().filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .peek(num -> System.out.println())
                .reduce(0, Integer::sum);

        System.out.println("addition ::" + addition);
    }
}
