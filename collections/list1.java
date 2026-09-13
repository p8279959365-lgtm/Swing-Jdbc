import java.util.*;
class list1{
    public static void main(String[] args)
    {
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("10");
        arr.add("20");
        arr.add("Pratham jain");
        arr.add("Radhe mohan");
        System.out.println(arr);
        System.out.println(arr.get(0));
        arr.remove("20");
        System.out.println(arr);
        ArrayList<String> arr2=new ArrayList<String>();
        arr2.add("20");
        arr2.add("30");
        arr.addAll(arr2);
        System.out.println(arr);
    }
}