import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    Statement statement;
     public DBConnection(){
           try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bankSystem","root","Kousik@7001");
            statement=connection.createStatement();
           }catch(Exception e){
            e.printStackTrace();
           } 
        }
    public static void main(String[] args) {
       new DBConnection();
    }
}
