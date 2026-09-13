import java.awt.*;
import javax.swing.*;
class borderLayout
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("Border Layout");
        obj.setLayout(new BorderLayout());
        JButton b1=new JButton("hi");
        JButton b2=new JButton("hello");
        JButton b3=new JButton("world");
        JButton b4=new JButton("Pratham");
        JButton b5=new JButton("Jain");
        obj.add(b1,BorderLayout.NORTH);
        obj.add(b4,BorderLayout.WEST);
        obj.add(b5,BorderLayout.EAST);
        obj.add(b2,BorderLayout.CENTER);
        obj.add(b3,BorderLayout.SOUTH);
        
        
        obj.pack();
        obj.setVisible(true);
    }
}