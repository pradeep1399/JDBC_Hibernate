//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String username = "postgres";
        String password = "postgres";
        try{
            //load the driver
            Class.forName("com.postgresql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if(connection.isClosed()){
                System.out.println("Connection is Closed");
            }else{
                System.out.println("Connection created...");
            }
        }catch(Exception e){
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}