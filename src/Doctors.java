import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctors {
    //    create parameterized constructors;
    Connection connect;

    public Doctors(Connection connection) {
        this.connect = connection;
    }

    // create function to show doctors list;
    void showDoctorsList() {
        String query = "SELECT * FROM doctors";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            ResultSet result = preState.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String specialization = result.getString("specialization");
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialization: " + specialization);
                System.out.println("=======================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    create a function to get doctors by id ;
    boolean getDocById(int id) {
        String query = "SELECT * FROM doctors WHERE id = ?";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            preState.setInt(1, id);
            ResultSet result = preState.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
