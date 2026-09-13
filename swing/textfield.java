





import javax.swing.*;
class textfield
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("text field");
        obj.setSize(500,500);
        obj.setLayout(null);
        JTextField t1=new JTextField("Hi pratham ");
        JTextField t2=new JTextField("I am from Agra");
        t1.setBounds(50,100,100,100);
        t2.setBounds(50,250,100,100);
        obj.add(t1);
        obj.add(t2);
        obj.setVisible(true);

    }
}