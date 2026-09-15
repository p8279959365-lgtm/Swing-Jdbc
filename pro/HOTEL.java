import java.sql.*;

public class HOTEL {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/HOTEL_MANAGEMENT_SYSTEM",
                "root",
                "Vikram@300978"
            );

            System.out.println("Database Connected Successfully!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}