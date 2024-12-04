package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//change the multiple methods into one method that varies the string query depending on the menu instruction chosen
//pls ignore how bulky this is, it will be streamlined later
public class PatientDBService {

    public static List<PatientType> searchPatientName(String first_name, String last_name) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "select * from patients WHERE first_name=? AND last_name=? LIMIT 10";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));


                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "select * from patients WHERE first_name=? OR last_name=? LIMIT 10";

        try (Connection connect = DatabaseConnection.getConnection();
             PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));


                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }



        public static List<PatientType> searchPatientByRoom(String roomNumber) throws SQLException{
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE room_number = ? LIMIT 10";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, roomNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));

                    LocalDateTime admDate = rs.getTimestamp("admission_date").toLocalDateTime();
                    patient.setAdminYear(dob.getYear());
                    patient.setAdminMonth(dob.getMonthValue());
                    patient.setAdminDay(dob.getDayOfMonth());

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

     public static List<PatientType> searchPatientsByMRN(String mrn) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE patient_id = ? LIMIT 10";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {

            stmt.setString(1, mrn);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    LocalDateTime admDate = rs.getTimestamp("admission_date").toLocalDateTime();
                    patient.setAdminYear(dob.getYear());
                    patient.setAdminMonth(dob.getMonthValue());
                    patient.setAdminDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));


                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
     }


    public static List<PatientType> searchPatientByPCP(String attending_physician) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE attending_physician = ? LIMIT 10";

        try (Connection connect = DatabaseConnection.getConnection();
             PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, attending_physician);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    LocalDateTime admDate = rs.getTimestamp("admission_date").toLocalDateTime();
                    patient.setAdminYear(dob.getYear());
                    patient.setAdminMonth(dob.getMonthValue());
                    patient.setAdminDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));

                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return patients;
    }

    public static List<PatientType> searchPatientAdmissionDate(String admissionDate) throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE admission_date = ? LIMIT 10";
        //pick up from here and modify all other search functions to incorporate lists to hold multiple returns
        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement stmt = connect.prepareStatement(query)) {
            stmt.setString(1, admissionDate);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PatientType patient = new PatientType();
                    patient.setMRN(rs.getString("patient_id"));
                    patient.setfname(rs.getString("first_name"));
                    patient.setlname(rs.getString("last_name"));

                    LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                    patient.setBirthYear(dob.getYear());
                    patient.setBirthMonth(dob.getMonthValue());
                    patient.setBirthDay(dob.getDayOfMonth());

                    LocalDateTime admDate = rs.getTimestamp("admission_date").toLocalDateTime();
                    patient.setAdminYear(dob.getYear());
                    patient.setAdminMonth(dob.getMonthValue());
                    patient.setAdminDay(dob.getDayOfMonth());

                    patient.setGender(rs.getString("gender"));


                    patient.setRoomNumber(rs.getString("room_number"));
                    patient.setPcpString(rs.getString("attending_physician"));
                    patient.setDiagnosis(rs.getString("diagnosis"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static List<PatientType> getAllPatients() throws SQLException {
        List<PatientType> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";

        try (Connection connect = DatabaseConnection.getConnection();
             PreparedStatement stmt = connect.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PatientType patient = new PatientType();
                patient.setMRN(rs.getString("patient_id"));
                patient.setfname(rs.getString("first_name"));
                patient.setlname(rs.getString("last_name"));

                LocalDateTime dob = rs.getTimestamp("date_of_birth").toLocalDateTime();
                patient.setBirthYear(dob.getYear());
                patient.setBirthMonth(dob.getMonthValue());
                patient.setBirthDay(dob.getDayOfMonth());

                patient.setGender(rs.getString("gender"));

                LocalDateTime admissionDate = rs.getTimestamp("admission_date").toLocalDateTime();
                patient.setAdminYear(admissionDate.getYear());
                patient.setAdminMonth(admissionDate.getMonthValue());
                patient.setAdminDay(admissionDate.getDayOfMonth());

                patient.setRoomNumber(rs.getString("room_number"));
                patient.setPcpString(rs.getString("attending_physician"));
                patient.setDiagnosis(rs.getString("diagnosis"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

}
