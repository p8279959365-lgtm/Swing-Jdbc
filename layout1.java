

import java.awt.BorderLayout;
import javax.swing.*;
class layout1
{
    public static void main(String[] args)
    {
        //create frame
        
        JFrame obj=new JFrame("BORDER LAYOUT");
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setSize(500,500);


        obj.setLayout(new BorderLayout());
        JButton b1,b2,b3,b4,b5;
        b1=new JButton("hi");
        b2=new JButton("hello");
        b3=new JButton("Harshit");
        b4=new JButton("bhai");
        b5=new JButton("love u");

        obj.add(b1,BorderLayout.NORTH);
        obj.add(b2,BorderLayout.WEST);
        obj.add(b3,BorderLayout.CENTER);
        obj.add(b4,BorderLayout.EAST);
        obj.add(b5,BorderLayout.SOUTH);
        obj.setVisible(true);







    }
}