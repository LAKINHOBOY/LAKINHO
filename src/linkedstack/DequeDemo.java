package linkedstack;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
       // Deque<String> name = new LinkedList<>();
        Deque<String> farah = new LinkedList<>();
        farah.addFirst("a");
        farah.addFirst("b");
        farah.addFirst("c");
        farah.pop();
        System.out.println("First: " + farah.getFirst());
        System.out.println("Last: " + farah.getLast());
    }
}
