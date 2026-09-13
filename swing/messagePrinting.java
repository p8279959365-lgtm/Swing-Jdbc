import java.awt.event.*;
import javax.swing.*;
class messagePrinting
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame();
        obj.setSize(600,600);
        obj.setLayout(null);

        JTextField jt=new JTextField();
        jt.setBounds(150,180,300,30);
        obj.add(jt);

        JButton b=new JButton("Submit");
        b.setBounds(250,230,100,30);
        obj.add(b);


        JLabel l2=new JLabel("MANIPAL UNIVERSITY ");
        JLabel l3=new JLabel("JAIPUR");

        l2.setBounds(250,100,300,50);
        obj.add(l2);

        l3.setBounds(275,120,300,50);
        obj.add(l3);


        JLabel l1=new JLabel("");
        obj.add(l1);
        l1.setBounds(150,300,400,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String s=jt.getText();
                l1.setText("Welcome "+s+" to Manipal University Jaipur Library ");
                jt.setText("");
            }
        });
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}