


import java.sql.*;
class deletion
{
    public static void main(String[] args)
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/insertion","root","Vikram@300978");
        String s="Delete from student where id=? ";
        PreparedStatement ps=con.prepareStatement(s);
        ps.setInt(1,1);
        int c=ps.executeUpdate();
        if(c>0)
        {
            System.out.println("The deletion was done succesfully");
        }
        else
        {
            System.out.println("The query was not executed");
        }
        

        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select * from student");
        while(res.next())
        {
            System.out.println(res.getInt(1)+" "+res.getString(2));
        }
        con.close();

        }
        catch(Exception e)
        {
            System.out.println("Exception occured");
        }

    }
}