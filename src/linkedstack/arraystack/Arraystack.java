package linkedstack.arraystack;

import java.util.Arrays;

public class Arraystack<T> {
    private static final int capacity = 2;
    private int top;
    private T[] stack;

    Arraystack() {
        this(capacity);
    }

    Arraystack(int size) {
        top = 0;
        stack = (T[]) new Object[size];
    }

    boolean Empty() {
        return top == 0;
    }

    int size() {
        return top;
    }

    void push(T element) {
        if (IFull()) {
            expand();
        }
        stack[top] = element;
        top++;
    }

    public void expand() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public String toString() {
        return "StackArray{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }

    T peak() {
        if (Empty()) {
            return null;
        }
        return stack[top - 1];
    }

    T pop() {
        if (Empty()) {
            return null;
        }
        top--;
        T removed = stack[top];
        stack[top] = null;
        return removed;
    }

    boolean IFull() {
        return top == stack.length;
    }

    void display() {
        if (Empty()) {
            System.out.println("Is Empty");
        }
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    private boolean duplicate(T element) {
        for (int i = 0; i < size(); i++) {
            if (stack[i] == element || (stack[i] != null && stack[i].equals(element))) {
                return true;
            }
        }
        return false;
    }

    public void merge(Arraystack<T> list1, Arraystack<T> list2) {
        int newSize = list1.size() + list2.size();

        if (stack.length < newSize) {
            stack = Arrays.copyOf(stack, newSize);
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!duplicate(list1.stack[i])) {
                this.push(list1.stack[i]);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (!duplicate(list2.stack[i])) {
                this.push(list2.stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        Arraystack<Integer> list1 = new Arraystack<>(3);
        Arraystack<Integer> list2 = new Arraystack<>(4);
        Arraystack<Integer> list3 = new Arraystack<>();

        list1.push(10);
        list1.push(10);
        list1.push(20);
        list1.push(20);

        list2.push(20);
        list2.push(200);
        list2.push(50);
        list2.push(50);

        list3.merge(list1, list2);
        list3.display();
    }
}