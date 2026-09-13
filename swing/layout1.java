import java.awt.*;
import javax.swing.*;
class layout1
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("Layout 1");
        // obj.setSize(500,500);
        obj.setLayout(new FlowLayout());
        obj.add(new JButton("hi"));
        obj.add(new JButton("jelly"));
        obj.add(new JButton("ram"));
        obj.pack();
        obj.setVisible(true);

    }
}