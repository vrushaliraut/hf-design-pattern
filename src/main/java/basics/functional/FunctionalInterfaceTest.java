package basics.functional;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        Greator<String> greator = (String arg1, String arg2) -> {
            System.out.println(arg1 + " " + arg2);
            return arg1 + " " + arg2;
        };

        System.out.println(greator.greeter("Hello", "Hello"));
    }
}
