
import javax.swing.*;
class swing1
{
    public static void main(String[] args)
    {

        JFrame jf=new JFrame();
        jf.setSize(500,500);
        JLabel obj=new JLabel("id:");
        obj.setBounds(50,100,150,20);
        jf.add(obj);
        JLabel obj2=new JLabel("Email: ");
        obj2.setBounds(50,50,50,20);
        jf.add(obj);
        jf.add(obj2);
        JTextField tx=new JTextField("Enter the id ");
        tx.setBounds(100,100,150,20);
        JTextField tx1=new JTextField("Enter name");
        tx1.setBounds(100,50,150,20);
        jf.setLayout(null);
        jf.add(tx);
        jf.add(tx1);
        jf.setVisible(true);
        JButton b=new JButton("Submit");
        b.setBounds(50,175,100,20);
        jf.add(b);



    }
}