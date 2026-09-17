

import java.sql.*;
class helloji
{
    
    public static void main(String[] args)
    {


        // the connection if not established can throw exception so to handle it we use try block here 

        try
        {

            // register driver class 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connection of the respective database 

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personal_info","root","Vikram@300978");

            // statement creation

            String s1="insert into info values (?,?)";
            PreparedStatement ps=con.prepareStatement(s1);
            // we will be setting the values of the parameter now

            ps.setInt(1,101);  
            ps.setString(2,"Harshit Harsh Marraige");
            

            int result=ps.executeUpdate();
            if(result>0)
            {
                System.out.println("the query was executed succesfully");
            }
            else
            {
                System.out.println("the query was not able to be executed");
            }




            
            // deletion of the entry

            PreparedStatement ps3=con.prepareStatement("delete from info where id=? ");
            ps3.setInt(1,101);
            ps3.executeUpdate();
            



            //  WE WILL BE PERFORMING THE SELECT OPERATION NOW


            Statement s2=con.createStatement();
            ResultSet res=s2.executeQuery("select * from info");

            while(res.next())
            {
                System.out.println(res.getInt(1)+" "+res.getString(2));
            }



            con.close();




            






            con.close();


        }
        catch(Exception e)
        {

            System.out.println("the exception has occured "+e);
        }
    }

}