import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patients {
    //     crete a parameterized constructor;
    Connection connect;
    Scanner scanner;

    public Patients(Connection connection, Scanner sc) {
        this.connect = connection;
        this.scanner = sc;
    }

    //     create a function for adding patients;
    void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        String query = "INSERT INTO patients(name,age, gender) VALUES(?,?,?);";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            preState.setString(1, name);
            preState.setInt(2, age);
            preState.setString(3, gender);
            int rowAffect = preState.executeUpdate();
            if (rowAffect > 0) {
                System.out.println("Patient added successfully");
            } else {
                System.out.println("Failed to add patient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    create a function to view all patients;
    void showPatientList() {
        String query = "SELECT * FROM patients;";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            ResultSet result = preState.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int age = result.getInt("age");
                String gender = result.getString("gender");
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Gender: " + gender);
                System.out.println("=====================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //     create a function to get patient by id;
    boolean getPatientById(int id) {
        String query = "SELECT * FROM patients WHERE id = ?";
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
