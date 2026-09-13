
import java.sql.*;
import java.util.*;
class libraryManagement
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","Vikram@300978");

        // asking what to do from the administrator 
        /*
        1- adding new book in stock 
        2- issueing a book
        3- seeing stock
        4- returning  books
        5- exit
        */
       // inventory atrributes book_id book_name stock


       
       int ch;
       System.out.println("Enter the operation to be performed ");
       do{

       System.out.print(" 1- adding new book in stock \n" + " 2- issuing a book\n" +  
                      " 3- seeing stock\n" + 
                      " 4-seeing book issued to whome by id\n 5-exit\n\n\n");
        ch=sc.nextInt();

        switch(ch){
            case 1:
                System.out.println("Enter the details of the book ");
                System.out.println("book id");
                int id=sc.nextInt();
                System.out.println("book name");
                String name=sc.nextLine();
                System.out.println("Enter the quantity in stock ");
                int stock=sc.nextInt();

                String q1=" insert into inventory values(?,?,?)";
                PreparedStatement ps1=con.prepareStatement(q1);
                ps1.setInt(1,id);
                ps1.setString(2,name);
                ps1.setInt(3,stock);
                int n=ps1.executeUpdate();
                if(n>0)
                {
                    System.out.println("new book added");
                }
                else
                {
                    System.out.println("Book was not added");
                }
                break;
            case 2:
                System.out.println("Enter the book id to be issued ");
                int b_id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the book name");
                String nm=sc.nextLine();
                System.out.println("Enter the student name:");
                String student_name=sc.nextLine();
                System.out.println("Enter the student id");
                int ids=sc.nextInt();



                // book remove from database 
                String q2=" update inventory set quantity=quantity-? where book_id=? ";
                PreparedStatement ps2=con.prepareStatement(q2);
                ps2.setInt(1,1);
                ps2.setInt(2,b_id);
                int res=ps2.executeUpdate();
                // book adding in issued 
                if(res==0)
                {
                    System.out.println("Book was not issued ");                       // inventory issued total_issued 
                }
                else
                {
/*create table issued(
book_id int,
book_name varchar(30),
student_name varchar(30),
student_id int); */
                    String q3="insert into issued values(?,?,?,?)";
                    PreparedStatement ps3=con.prepareStatement(q3);
                    ps3.setInt(1,b_id);
                    ps3.setString(2,nm);
                    ps3.setString(3,student_name);
                    ps3.setInt(4,ids);
                    int rr=ps3.executeUpdate();
                    if(rr>0)
                        System.out.println("Book was issued ");
                    else
                        System.out.println("not issued ");
                }
                break;

                /* For displaying inventory  */
            case 3:
                System.out.println("Inventory is: ");

                Statement stmt=con.createStatement();
                ResultSet resu=stmt.executeQuery("select * from inventory");
                while(resu.next())
                {
                    System.out.println(resu.getInt(1)+" "+resu.getString(2)+" "+resu.getInt(3));
                }
                System.out.println();
                System.out.println();
                System.out.println();
                break;

                /* for displaying issued to whome ie issued database  */
            case 4:
                 System.out.println("Inventory is: ");

                Statement stmt2=con.createStatement();
                ResultSet resul=stmt2.executeQuery("select * from issued");
                while(resul.next())
                {
                    System.out.println(resul.getInt(1)+" "+resul.getString(2)+" "+resul.getString(3)+" "+resul.getString(4));
                }
                break;

            case 5:
                System.out.println("THANKS FOR USING OUR LIBRARAY ");
                break;
        }
        }while(ch!=5);
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}