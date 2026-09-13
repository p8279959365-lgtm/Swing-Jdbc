

import javax.swing.*;
class button
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("Button example");
        obj.setSize(500,500);
        obj.setLayout(null);
        JButton b1=new JButton("click me");
        b1.setBounds(150,200,100,20);
        obj.add(b1);
        obj.setVisible(true);
    }
}