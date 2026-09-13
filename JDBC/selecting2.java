import java.sql.*;

class selecting2
{
    public static void main(String[] args)
    {
        try{

        
        //class object
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Vikram@300978");
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select* from student");
        while(res.next())
        {
            System.out.println(res.getInt(2)+" "+res.getString(1));
        }
        con.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }
}
