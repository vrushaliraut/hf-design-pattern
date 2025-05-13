package basics.generics;

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericsWithTypeParam {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 42);
        System.out.println(pair.getKey() + " " + pair.getValue());  //Output Age 42
    }
}
