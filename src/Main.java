import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);

//            create objects;
            Patients patients = new Patients(connect, sc);
            Doctors doctors = new Doctors(connect);
            Management management = new Management(connect, sc);


// show options to the user to use functionality of the HMS;
            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. View Appointments.");
                System.out.println("5. Book Appointment.");
                System.out.println("6. Exit.");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

//              set functionality according to the choice
                switch (choice) {
                    case 1:
                        patients.registerPatient();
                        System.out.println();
                        break;
                    case 2:
                        patients.showPatientList();
                        System.out.println();
                        break;
                    case 3:
                        doctors.showDoctorsList();
                        System.out.println();
                        break;
                    case 4:
                        management.showAppointments();
                        System.out.println();
                        break;
                    case 5:
                        management.bookAppointment(patients, doctors);
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                        management.exit();
                        return;
                    default:
                        System.out.println("Invalid Choice. Try Again!");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}