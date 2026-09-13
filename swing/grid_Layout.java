import java.awt.*;
import javax.swing.*;
class grid_Layout
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("Grid Layout");
        obj.setSize(500,500);
        obj.setLayout(new GridLayout(3,3));

        int i;
        for(i=0;i<9;i++)
        {
            obj.add(new JButton("button "+i));
        }
        obj.pack();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


