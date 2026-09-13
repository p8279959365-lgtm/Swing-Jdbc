import java.sql.*;
class insertion
{
    public static void main(String[] args)
    {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","Vikram@300978");
        String sql="insert into student(name,mobileno) Values(?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,"Ram");
        ps.setInt(2,2);
        int result=ps.executeUpdate();
        if(result>0)
        {
            System.out.println("The query was updated succesfully");
        }
        else
        {
            System.out.println("The query  was not updated succesfully");
        }
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select * from student");
        while(res.next())
        {
            System.out.println(res.getInt(2)+" "+res.getString(1));
        }
        con.close();
        }
        catch(Exception e)
        {
            System.out.println("error");
        }
    }
}