




import java.sql.*;
import java.util.*;
class stock
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","Vikram@300978");
        System.out.println("Products are ");
        Statement stmt=con.createStatement();
        ResultSet res=stmt.executeQuery("select * from product");
        System.out.println("p_id  product_name   stock");
        while(res.next())
        {
            System.out.println(res.getInt(1)+"  "+res.getString(2)+"  "+res.getInt(3));
        }
        System.out.println();
        System.out.println("Enter the product id : ");

        int s=sc.nextInt();
        System.out.println();
        System.out.println("Enter the quantity to be booked ");
        int q=sc.nextInt();
        String q1=" update product set stock=stock-? where product_id=? ";
        PreparedStatement ps=con.prepareStatement(q1);
        con.setAutoCommit(false);
        ps.setInt(1,q);
        ps.setInt(2,s);
        int r=ps.executeUpdate();
        if(r==0)
        {
            System.out.println("the order was not booked ");
        }
        
        else
        {
            String q2=" update orders set quantity=quantity+? where product_id=?";
            PreparedStatement ps2=con.prepareStatement(q2);
            ps2.setInt(1,q);
            ps2.setInt(2,s);
            int x=ps2.executeUpdate();
            if(x==0)
            {
                System.out.println("the order was Not booked succesfully ");
            }
            else
            {
                System.out.println("the order was booked succesfully ");
            }
        }
        System.out.println("INVENTORY CURRENT STATUS: ");
        ResultSet res2=stmt.executeQuery("select * from product ");
        System.out.println("p_id  product_name   stock");
        while(res2.next())
        {
            System.out.println(res2.getInt(1)+"  "+res2.getString(2)+"  "+res2.getInt(3));
        }
        con.commit();
        con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}