package basics.generics;

class Box<T>{
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class GenericsBasic {
    public static void main(String[] args) {
        // Use Box with integer type parameter
        Box<Integer> box = new Box<>();
        box.setContent(42);
        System.out.println(box.getContent()); //Output 42

        // Use Box with String type parameter
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello");
        System.out.println(stringBox.getContent()); //Output Hello
    }
}
