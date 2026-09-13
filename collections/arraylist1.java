import java.util.*;
class arraylist1{
    public static void main(String[] args)
    {
        ArrayList arr=new ArrayList();
        arr.add("10");
        arr.add(20);
        System.out.println(arr);
        arr.set(1,200);
        arr.add(3);
        System.out.println(arr);
        arr.add(300);
        ArrayList ar1=new ArrayList();
        ar1.add(20);
        ar1.add("Pratham");
        ar1.add("Rjan");
        arr.addAll(ar1);
        System.out.println(arr);
    }
}