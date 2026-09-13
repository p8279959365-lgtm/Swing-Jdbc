


import java.sql.*;
class Account
{
    public static void main(String[] args)
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Vikram@300978");
        con.setAutoCommit(false);
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select * from account");
        System.out.println("CURRENT ACCOUNT STATUS");
        while(res.next())
        {
            System.out.println(res.getInt(1)+" "+res.getInt(2));
        }
        String q1=" update account set balance=balance-? where accno=? ";
        PreparedStatement ps=con.prepareStatement(q1);
        ps.setInt(1,1000);
        ps.setInt(2,101);
        int n=ps.executeUpdate();
        if(n>0)
        {
            System.out.println("Money: 1000 was deducted \naccno:101");
            PreparedStatement ps2=con.prepareStatement("Update account  set balance=balance+? where accno=? ");
            ps2.setInt(1,1000);
            ps2.setInt(2,102);
            int c2=ps2.executeUpdate();
            con.commit();
            if(c2>0)
            {
                System.out.println("Money: 1000 was deposited \naccno:102");
            }
            else
            {
                System.out.println("money was  deducted but not added");
            }
            System.out.println("Printing account balances: ");

        }
         System.out.println("AFTER TRANSICTION ACCOUNT STATUS");
         ResultSet res2=stmt.executeQuery("select * from account");
        while(res2.next())
        {
            System.out.println(res2.getInt(1)+" "+res2.getInt(2));
        }
        con.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception occured");
        }
    }
     
}