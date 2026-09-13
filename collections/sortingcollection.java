import java.util.*;
class sortingcollection
{
    public static void main(String[] args)
    {
        ArrayList arr=new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(50);
        arr.add(5);
        arr.add(8);
        Collections.sort(arr);
        System.out.println(arr);
    }
}