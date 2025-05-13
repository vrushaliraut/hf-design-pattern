package basics.generics;

import java.util.List;

// code duplication - >
// you can use Objects everywhere but typesafety  will compromise -
public class GenericsDemo {
    public static void main(String[] args) {

        /* Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        StringNode headString = new StringNode("Hello");
        headString.next = new StringNode("World");
*/

        NodeGeneric<Integer> headGeneric = new NodeGeneric<>(10);
        headGeneric.next = new NodeGeneric<>(20);
        headGeneric.print();

        NodeGeneric<Double> doubleGeneric = new NodeGeneric<>(10.60);
        doubleGeneric.next = new NodeGeneric<>(20.60);
        doubleGeneric.print();

        NodeGeneric<String> stringGeneric = new NodeGeneric<>("generic");
        stringGeneric.next = new NodeGeneric<>("string");
        stringGeneric.print();


    }


    static class NodeGeneric<T> {
        T data;
        NodeGeneric next;

        public NodeGeneric(T data) {
            this.data = data;
        }

        public <T> void print() {
            while (next != null) {
                System.out.println(data + "->");
                next = next.next;
            }
        }

        @Override
        public String toString() {
            return "NodeGeneric{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    static class StringNode {
        String data;
        StringNode next;

        public StringNode(String data) {
            this.data = data;
        }
    }
}


