import java.lang.*;
public class thread1 extends Thread
{
    public void run()
    {
        System.out.println("hi i am a thread");
    }
    public static void main(String[] args)
    {
        thread1 obj=new thread1();
        obj.run();
    }
}