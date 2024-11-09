package STAck;
import java.util.*;
import java.util.List;


public class MergeStack {
    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3 = new ArrayList<>(list1); // Start with all elements from list1

        // Add elements from list2, but   if they're not already in list3
        for (Integer element : list2) {
            if (!list3.contains(element)) {
                list3.add(element);
            }
        }

        return list3;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(900);
        list1.add(500);
        list1.add(500);

        List<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(100);
        list2.add(900);
        list2.add(900);

        List<Integer> list3 = merge(list1, list2);

        System.out.println("Merged list without duplicates: " +list3);
    }
}

