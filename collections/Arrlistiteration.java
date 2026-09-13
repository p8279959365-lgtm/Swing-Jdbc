import java.util.*;
class Arrlistiteration{
    public static void main(String[] args)
    {
        ArrayList arr=new ArrayList();
        arr.add("100");
        arr.add("Pratham jain");
        arr.add("Radhe");
        arr.add(20);
        int i;
        for(i=0;i<arr.size();i++)
        {
            System.out.println(arr.get(i));
        }
    }
}