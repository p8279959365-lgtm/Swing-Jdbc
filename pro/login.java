




import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
class login
{//hi
    public static void main(String[] args)
    {
        JFrame obj=new JFrame("login portal");
        obj.setSize(600,600);
        obj.setLayout(null);

        JLabel l1=new JLabel("Registratio number ");
        l1.setBounds(130, 180, 120, 30);
        obj.add(l1);
        JTextField t1=new JTextField();
        t1.setBounds(260, 180, 180, 30);
        obj.add(t1);

        JLabel l2=new JLabel("Name ");
        l2.setBounds(130, 230, 120, 30);
        obj.add(l2);
        JTextField t2=new JTextField("");
        t2.setBounds(260, 230, 180, 30);
        obj.add(t2);

        JButton b=new JButton("submit");
        b.setBounds(250, 290, 100, 35);
        obj.add(b);

        JLabel l3=new JLabel("");
        l3.setBounds(220,330,400,50);
        obj.add(l3);

        //connecting to the database 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Vikram@300978");


            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                     String nm=t2.getText();
                     long id=Long.parseLong(t1.getText());
                     String sql="insert into entry values (?,?)";
                     try{
                     PreparedStatement ps=con.prepareStatement(sql);
                     ps.setLong(1,id);
                     ps.setString(2,nm);
                     ps.executeUpdate();
                     t1.setText("");
                     t2.setText("");
                     l3.setText(nm+" is Registered Succesfully");
                     }
                     catch(Exception ex)
                     {
                        l3.setText(nm+" is already Registered ");
                     }
                }
            });
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }



    }
}