import java.lang.*;
public class namingthread implements Runnable
{
    public void run()
    {
        System.out.println("The thread is running");
    }

    public static void main(String[] args)
    {
        namingthread obj=new namingthread();
        Thread obj2=new Thread(obj,"Pratham Thread");
        obj2.run();
        System.out.println(obj2.getName());
    }
}