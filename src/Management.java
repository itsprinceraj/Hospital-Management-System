import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Management {
    //    create parameterized constructors;
    Connection connect;
    Scanner scanner;

    public Management(Connection connection, Scanner sc) {
        this.connect = connection;
        this.scanner = sc;
    }

    //     create a function to book appointments;
    void bookAppointment(Patients patients, Doctors doctors) {
        System.out.print("Enter Patient Id: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor Id: ");
        int docId = scanner.nextInt();
        System.out.println("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.next();
        if (patients.getPatientById(patientId) && doctors.getDocById(docId)) {
            if (docAvailable(docId, date)) {
                String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES(?,?,?);";
                try {
                    PreparedStatement preState = connect.prepareStatement(query);
                    preState.setInt(1, patientId);
                    preState.setInt(2, docId);
                    preState.setString(3, date);
                    int rowAffect = preState.executeUpdate();
                    if (rowAffect > 0) {
                        System.out.println("Appointment booked successfully");
                    } else {
                        System.out.println("Failed to Book Appointment");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Doctor Not Available on this Date.");
            }
        } else {
            System.out.println("Either Patient or Doctor Not Available");
        }

    }

    //    create a function to check doctors are available or not;
    boolean docAvailable(int docId, String date) {
        String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ?";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            preState.setInt(1, docId);
            preState.setString(2, date);
            ResultSet result = preState.executeQuery();
            if (result.next()) {
                int count = result.getInt(1);
                return count == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // create a function to see appointments;
    void showAppointments() {
        String query = "SELECT * FROM appointments;";
        try {
            PreparedStatement preState = connect.prepareStatement(query);
            ResultSet result = preState.executeQuery();
            while (result.next()) {
                int patient_id = result.getInt("patient_id");
                int doctor_id = result.getInt("doctor_id");
                String date = result.getString("appointment_date");
                System.out.println();
                System.out.println("Patient Id: " + patient_id);
                System.out.println("Doctor Id: " + doctor_id);
                System.out.println("Appointment Date: " + date);
                System.out.println("=====================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    create a function for exit;
    void exit() {
        int i = 5;
        System.out.print("Exiting System");
        while (i != 0) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}
