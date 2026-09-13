



import java.awt.event.*;
import javax.swing.*;
class actionlistener
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame();
        obj.setSize(500,500);
        obj.setLayout(null);
        JTextField t1=new JTextField();
        t1.setBounds(20,40,200,30);
        obj.add(t1);

        JButton b1=new JButton("Click Here");
        b1.setBounds(20,100,100,20);
        obj.add(b1);

        b1.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
            {
                System.out.println("hello");
                t1.setText("SUBMISSION SUCCESFUL");
            }
        });
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}