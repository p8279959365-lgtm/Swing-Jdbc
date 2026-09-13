import java.util.*;
class TreeSet1
{
    public static void main(String[] args)
    {
        TreeSet<Integer>ts=new TreeSet<>();
        ts.add(12);
        ts.add(132);
        ts.add(10);
        ts.add(22);
        ts.add(3);
        ts.add(10);
        System.out.println(ts); // Stores elements in sorted manner
        System.out.println(ts.contains(12));
        
    }
}