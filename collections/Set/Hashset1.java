import java.util.*;
class Hashset1
{
    public static void main(String[] args)
    {
        HashSet<Integer>arr=new HashSet<>();
        arr.add(10);
        arr.add(20);
        arr.add(36);
        arr.add(10);
        System.out.println(arr);
        if(arr.contains(22))
        {
            arr.remove(22);
        }
        else
        {
            arr.add(22);
            int num=arr.size();
            arr.add(num);
        }
        System.out.println(arr);
    }
}