import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //     credentials;
    private final static String url = "jdbc:mysql://localhost:3306/hospital_ms";
    private final static String userName = "root";
    private final static String pass = "5466";

    public static void main(String[] args) {

//        connect to db;
        try {
//            load drivers;
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//         db call
        try {
            Connection connect = DriverManager.getConnection(url, userName, pass);

// show options to the user to use functionality of the HMS;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}