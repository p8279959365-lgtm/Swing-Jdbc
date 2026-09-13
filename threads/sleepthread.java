class sleepthread extends Thread{
    public void run(){
        int i;
        for(i=0;i<3;i++)
        {
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                System.out.println("Exception handeled");
            }    
            System.out.println(i);   
         }
    }
    public static void main(String[] args)
    {
        sleepthread obj=new sleepthread();
        sleepthread obj2=new sleepthread();
        obj.start();
        obj2.start();
    }
}