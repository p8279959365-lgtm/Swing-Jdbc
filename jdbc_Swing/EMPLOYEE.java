import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
class EMPLOYEE
{
    public static void main(String[] args)
    {

        JFrame jf=new JFrame();
        jf.setSize(800,800);

        jf.setLayout(null);

        JTextField t1=new JTextField("ID:");
        t1.setBounds(50,50,150,20);

        JTextField t2=new JTextField("NAME");
        t2.setBounds(50,100,150,20);

        JTextField t3=new JTextField("SALARY");
        t3.setBounds(50,150,150,20);

        jf.add(t1);
        jf.add(t2);
        jf.add(t3);
        JButton b1=new JButton("SUBMIT");
        b1.setBounds(100,200,100,20);

        jf.add(b1);

        



        b1.addActionListener(new ActionListener()
        {public void actionPerformed(ActionEvent e)
            {

                
                int id=Integer.parseInt(t1.getText());
                String nm=t2.getText();
                int sal=Integer.parseInt(t3.getText());


                t1.setText("");
                t2.setText("");
                t3.setText("");



                 try{

            // register the driver class 
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection to database

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hiring","root","Vikram@300978");

            //Prepared statement 

            PreparedStatement stmt=con.prepareStatement("insert into employee values (?,?,?)");
            stmt.setInt(1,id);
            stmt.setString(2,nm);
            stmt.setInt(3,sal);

            stmt.executeUpdate();

            con.close();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        catch(Exception x)
        {
            System.out.println("Exception  was caught "+x);
        }

            }

        });


        jf.setVisible(true);

        

       














    }
}


