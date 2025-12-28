import java.util.*;

public class damo3 {
    public static void main(String[] args) {
        Queue<Integer> a=new PriorityQueue<> ();
        
        a.add(2343);
        a.add(35);
        a.add(98);

        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
    }
}