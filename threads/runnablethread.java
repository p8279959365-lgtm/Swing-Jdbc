import java.lang.*;
class runnablethread implements Runnable
{
    public void run()
    {
        System.out.println("I am a thread");
    }
    public static void main(String[] args)
    {
        runnablethread obj=new runnablethread();
        Thread obj2=new Thread(obj);
        obj2.run();
    }
}
