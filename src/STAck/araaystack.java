package STAck;

import java.util.Arrays;
import java.util.EmptyStackException;

public class araaystack<T> {
    private static final int DEFAULT_CAPACITY = 4;
    private int top;
    private T[] stack;

    public araaystack() {
        this(DEFAULT_CAPACITY);
    }
    public araaystack(int size) {
        top = 0;
        stack = (T[]) new Object[size];
    }


    int size(){
        return top;

    }
    boolean isempty(){
        return top == 0;
    }
    boolean isfull(){
        return top == stack.length;
    }
    void push(T item) {
        if (isfull())

            expandcapacity();
        stack[top] = item;
            top++;


    }
    private void expandcapacity(){
        stack= Arrays.copyOf(stack, stack.length*2);

    }
    public String getlenght(){
        return String.valueOf(stack.length);

    }
    T pop() throws EmptyStackException{
       if (isempty())
           throw new EmptyStackException();


       top--;

           T REMOVEDelement = stack[top];
           stack[top] = null;
           return REMOVEDelement;
       }

       public void display() {
            for (int i = top - 1 ; i >= 0; i--){
                System.out.print(stack[i] + " ");
            }
       }
       public void merge(araaystack<T> list1,araaystack< T> list2){

        int size=list1.size()+list2.size();
        if (stack.length < size){
            stack = Arrays.copyOf(stack, size);
        }
        for (int i = 0; i < list1.size(); i++) {
            boolean duplicate = true;
            if (!duplicate){
                this.push(list1.stack[i]);
            }

        }
           for (int i = 0; i < list2.size(); i++) {
               boolean duplicate = true;

           }



           System.out.println(list1+""+list2);





       }

    @Override
    public String toString() {
        return "araaystack{" +
                "top=" + top +
                ", stack=" + Arrays.toString(stack) +
                '}';
    }
    public static void main(String[] args) {
//        araaystack<String> a = new araaystack<String>();
//        a.push("A");
//        a.push("B");
//        a.push("C");
//        a.push("D");
//        System.out.println(a.isfull());
//        System.out.println(a.getlenght());
//        System.out.println(a.top);
//        System.out.println(a.toString());
//        a.display();
        araaystack<Integer> list1 = new araaystack<Integer>();
        araaystack<Integer> list2 = new araaystack<Integer>();
        araaystack<Integer> list3 = new araaystack<Integer>();
        list1.push(1);
        list1.push(1);
        list1.push(3);
        list1.push(3);

        list2.push(8);
        list2.push(3);
        list2.push(7);
        list3.merge(list1, list2);



    }
}
