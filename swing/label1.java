

import javax.swing.*;
class label1
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("Labels testing ");
        obj.setSize(500,500);
        obj.setLayout(null);
        JLabel l1=new JLabel("First Lable");
        JLabel l2=new JLabel("Second Lable");
        l1.setBounds(50,50,100,200);
        l2.setBounds(50,100,100,200);
        obj.add(l1);
        obj.add(l2);
        obj.setVisible(true);
        
    }
}