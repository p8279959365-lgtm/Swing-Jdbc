// import javax.swing.*;

// class demo
// {
//     public static void main(String[] args)
//     {
//         // JFrame obj=new JFrame();
//         // obj.setSize(400,400);
//        // loda.setLayout(null);
//         // loda.setVisible(true);
//         // // add button
//         // JButton b=new JButton("hi");
//         // b.setBounds(150,100,100,50);
//         // loda.add(b);
//         JFrame obj=new JFrame();
//         obj.setSize(400,400);
//         obj.setLayout(null);
        

//         JLabel l1=new JLabel("Whats your name??");
//         l1.setBounds(10,50,120,30);
//         obj.add(l1);

//         // label 2

//         JLabel l2=new JLabel("which city are you from? ");
//         l2.setBounds(10,80,150,30);
//         obj.add(l2);

//         // text box for label 1

//         JTextField tf1=new JTextField("");
//         tf1.setBounds(155,50,100,20);
//         obj.add(tf1);

//         //text box 2

//         JTextField tf2=new JTextField("");
//         tf2.setBounds(155,80,100,20);
//         obj.add(tf2);

//         //Button submit

//         // JButton b=new JButton("SUBMIT");
//         // b.setBounds(100,100,80,20);
//         // obj.add(b);
//         obj.setVisible(true);
        
//     }
// }

import javax.swing.*;
class demo
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame();
        obj.setSize(500,500);
        obj.setVisible(true);

        JButton b1=new JButton("click me");
        b1.setBounds(20,50,200,50);
        obj.add(b1);




        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




















