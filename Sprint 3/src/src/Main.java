package src;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void showmenu1() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.printf("-------------Main Menu---------------\n");
            System.out.printf("What search would you like? \n");
            System.out.printf("1. Basic search...\n");
            System.out.printf("2. Advanced search...\n");
            System.out.printf("3. Print all Patients...\n");
            System.out.printf("4. Call a doctor...\n");
            System.out.printf("9. Exit\n");

            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                System.out.printf("--------Basic Search-------------\n");
                System.out.printf("Enter patient first name...\n");
                String firstName = scanner.nextLine();
                System.out.printf("Enter patient last name...\n");
                String lastName = scanner.nextLine();
                String[] patientNames = basicPatientSearch(firstName, lastName);
                if (patientNames.length == 0) {
                    System.out.printf("No patients found with that name.\n");
                } else {
                    System.out.printf("Patients found:\n");
                    for (String name : patientNames) {
                        System.out.println(name);
                    }
                }
            } else if (choice.equalsIgnoreCase("2")) {
                showmenu2();
            } else if (choice.equalsIgnoreCase("3")) {
                List<PatientType> patients = PatientDBService.getAllPatients();
                int start = 0;
                int end = Math.min(100, patients.size());
                scanner = new Scanner(System.in);

                while (start < patients.size()) {
                    for (int i = start; i < end; i++) {
                        PatientType patient = patients.get(i);
                        System.out.println(patient.getPatientFName() + " " + patient.getPatientLName());
                    }
                    if (end == patients.size()) {
                        break;
                    }
                    System.out.println("Press Enter to see the next 100 patients...");
                    scanner.nextLine();
                    start = end;
                    end = Math.min(end + 100, patients.size());
                }
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.printf("Calling doctor on call");
                callingDr();
            }
        } while (!(choice.equals("9")));
    }

    public static void showmenu2() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.printf("--------Advanced Search-------------\n");
            System.out.printf("Search by... \n");
            System.out.printf("1. Room number \n");
            System.out.printf("2. Medical Record Number \n");
            System.out.printf("3. Admission Date \n");
            System.out.printf("4. Primary Care Provider \n");
            System.out.printf("9. Exit \n");
            choice = scanner.nextLine();
            String[] patientNames = new String[0];

            if (choice.equalsIgnoreCase("1")) {
                System.out.printf("Enter the room\n");
                String room = scanner.nextLine();
                patientNames = roomSearch(room);
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.printf("Enter the MRN\n");
                String MRN = scanner.nextLine();
                patientNames = mrnSearch(MRN);
            } else if (choice.equalsIgnoreCase("3")) {
                System.out.printf("Enter the Admission Date in day, month, year \n");
                int addDay = scanner.nextInt();
                int addMonth = scanner.nextInt();
                int addYear = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                patientNames = admissionDateSearch(addDay, addMonth, addYear);
            } else if (choice.equalsIgnoreCase("4")) {
                System.out.printf("Enter the PCP\n");
                String PCP = scanner.nextLine();
                patientNames = pcpSearch(PCP);
            }

            if (patientNames.length == 0) {
                System.out.printf("No patients found.\n");
            } else {
                System.out.printf("Patients found:\n");
                for (String name : patientNames) {
                    System.out.println(name);
                }
            }
        } while (!(choice.equals("9")));
    }

    public static void callingDr() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
            }
            System.out.printf(".");
            if (i == 2)
                System.out.printf("\n");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }
        System.out.println("But no one answered...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }
        System.out.println("Good luck lol");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }
    }

    public static String[] basicPatientSearch(String fname, String lname) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientName(fname, lname);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] roomSearch(String roomNum) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientByRoom(roomNum);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] mrnSearch(String MRN) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientsByMRN(MRN);
        String[] patientNames = new String[patients.size()];

        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] pcpSearch(String PCP) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientByPCP(PCP);
        String[] patientNames = new String[patients.size()];
        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] admissionSearch(String search) throws SQLException {
        List<PatientType> patients = PatientDBService.searchPatientAdmissionDate(search);
        String[] patientNames = new String[patients.size()];
        if (!patients.isEmpty()) {
            for (int i = 0; i < patients.size(); i++) {
                PatientType patient = patients.get(i);
                String fullname = patient.getPatientFName() + " " + patient.getPatientLName() + " " + patient.getMRN();
                patientNames[i] = fullname;
            }
        }
        return patientNames;
    }

    public static String[] admissionDateSearch(int day, int month, int year) throws SQLException {
        String search = year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day);
        return admissionSearch(search);
    }

    public static String[] ptnSelected(String ptn) throws SQLException {
        String parts[] = ptn.split(" ",3);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Input string does not contain enough parts");
        }
        String mrn = parts[2];
        //PatientType patient = mrnSearch(mrn);
        List<PatientType> patients = PatientDBService.searchPatientsByMRN(mrn);
        PatientType newpatient = null;
        if (!patients.isEmpty()) {
            newpatient = patients.get(0);
        }
        String ptnInfo[] = new String[6];
        if (newpatient != null) {
            ptnInfo[0] = newpatient.getPatientLName() + " " + newpatient.getPatientFName();
            ptnInfo[1] = newpatient.getMRN();
            ptnInfo[2] = newpatient.getRoomNumber();
            ptnInfo[3] = newpatient.getPcpString();
            ptnInfo[4] = newpatient.getDiagnosis();
            ptnInfo[5] = newpatient.getGender();
        }
        return ptnInfo;
    }

    public static String[] searchSelect(String searchType, String searchParam) throws SQLException {
        switch (searchType) {
            case "Last Name First Name":
                String parts[] = searchParam.split(" ", 2);
                String lastName = parts[0];
                String firstName = parts[1];
                return basicPatientSearch(firstName, lastName);
            case "Room Number":
                return roomSearch(searchParam);
            case "Medical Record Number":
                return mrnSearch(searchParam);
            case "Primary Care Provider ":
                return pcpSearch(searchParam);
            case "Admission Date":
                return admissionSearch(searchParam);
            default:
                return null;
        }
    }

    //new method for adding patient, Eli call this
    public static void addPtn(String [] newPtnInfo) throws SQLException {
        String ptnInfo[] = new String[6];
        //last name,first name, patient id, pcp id, diagnosis, gender
        for (int i = 0; i < newPtnInfo.length; i++) {
            ptnInfo[i] = newPtnInfo[i];
        }
        String add = "INSERT INTO patients (first_name, last_name, patient_id, room_number, attending_physician, diagnosis, admission_date, discharge_date, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String search = "SELECT * FROM Patients WHERE patient_id = ? LIMIT 10";
        String getMaxIdQuery = "SELECT MAX(patient_id) FROM Patients";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement searchstmt = connect.prepareStatement(search);
        PreparedStatement getMaxIdStmt = connect.prepareStatement(getMaxIdQuery);
        PreparedStatement addstmt = connect.prepareStatement(add)){

// Parse full name into first name and last name
        String fullName = newPtnInfo[0];
        String[] nameParts = fullName.split(" ", 2);
        String lastName = nameParts[0];
        String firstName = nameParts.length > 1 ? nameParts[1] : "";


            //search.setString(1,ptnInfo[2]);
            String newPatientId = "001";

            try (ResultSet rs = getMaxIdStmt.executeQuery()) {
                //find patient here and insert using seedPhysicians as a guide
                if (rs.next() && rs.getString(1) != null) {
                    //System.out.println("Ptn already exists");
                    String maxIdStr = rs.getString(1);

                    int maxId = Integer.parseInt(maxIdStr);
                    newPatientId = String.format("%04d", maxId + 1);

                }
            }
            //TODO ALIGN SQL STATEMENT WITH PASSED ARRAY
            //0 lastname firstname  (needs to be parsed)
            //1 patient id
            //2 room number
            //3 pcp id
            //4 events (ignore for now)
            //5 diagnosis
            String roomNum = newPtnInfo[2];
            Random random = new Random();
            Date admissionDate = new Date(System.currentTimeMillis() - (random.nextInt(10) * 24L * 60L * 60L * 1000L));
            Date dischargeDate = random.nextBoolean() ? new Date(admissionDate.getTime() + (random.nextInt(5) * 24L * 60L * 60L * 1000L)) : null; // Within 5 days or null
            Date dateOfBirth = new Date(System.currentTimeMillis() - ((random.nextInt(60) + 20) * 365L * 24 * 60 * 60 * 1000L + random.nextInt(365) * 24L * 60 * 60 * 1000L)); // Age 20-80 with more variation



            addstmt.setString(1, firstName);//first name
            addstmt.setString(2, lastName);//last name
            addstmt.setString(3, newPatientId);//patient id
            addstmt.setString(4, roomNum); //room num
            addstmt.setString(5, newPtnInfo[3]);//pcp id
            addstmt.setString(6, newPtnInfo[4]);//Diagnosis
            addstmt.setDate(7, admissionDate);
            if (dischargeDate != null) {
                addstmt.setDate(8, dischargeDate);
            } else {
                addstmt.setNull(8, java.sql.Types.DATE);
            }
            addstmt.setDate(9, dateOfBirth);



            int rowsAffected = addstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Ptn added");
            } else {
                System.out.println("Ptn not added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //new method for updating patient in database, Eli call this
    public static void updatePtn(String [] newPtnInfo) throws SQLException {
        //last name,first name, patient id, pcp id, diagnosis, gender
        String updateQuery = "UPDATE patients SET first_name = ?, last_name = ?, attending_physician = ?, diagnosis = ?, gender = ?, room_number = ? WHERE patient_id = ?";

        try (Connection connect = DatabaseConnection.getConnection();
        PreparedStatement updateStmt = connect.prepareStatement(updateQuery)) {

        String[] nameParts = parseName(newPtnInfo[0]); // Assuming newPtnInfo[0] contains "LastName FirstName"
        String lastName = nameParts[0];
        String firstName = nameParts[1];


                        //TODO ALIGN SQL STATEMENT WITH PASSED ARRAY
            //0 lastname firstname  (needs to be parsed)
            //1 patient id
            //2 room number
            //3 pcp id
            //4 events (ignore for now)
            //5 diagnosis
            String patient_id = newPtnInfo[1];
            String roomNum = newPtnInfo[2];
            String pcp = newPtnInfo[3];
            String diagnosis = newPtnInfo[4];
            String gender = newPtnInfo[5];


            //Set parameters based on ptnInfo array
            updateStmt.setString(1, firstName);//first name
            updateStmt.setString(2, lastName);//last name
            updateStmt.setString(3, pcp);//pcp id
            updateStmt.setString(4, diagnosis);//Diagnosis
            updateStmt.setString(5, gender);//gender
            updateStmt.setString(6, roomNum);//room number
            updateStmt.setString(7, patient_id);//patient id

            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Ptn updated");
            } else {
                System.out.println("Ptn not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNextPatientId() throws SQLException {
        String getMaxIdQuery = "SELECT MAX(patient_id) FROM Patients";
        String nextPatientId = "0001"; // Default ID if no patients exist

        try (Connection connect = DatabaseConnection.getConnection();
             PreparedStatement getMaxIdStmt = connect.prepareStatement(getMaxIdQuery)) {

            try (ResultSet rs = getMaxIdStmt.executeQuery()) {
                if (rs.next() && rs.getString(1) != null) {
                    // Get the highest patient ID and increment it
                    String maxIdStr = rs.getString(1);
                    int maxId = Integer.parseInt(maxIdStr);
                    nextPatientId = String.format("%04d", maxId + 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return nextPatientId;
    }

    private static String[] parseName(String fullName) {
    String[] nameParts = fullName.split(" ", 2);
    String lastName = nameParts[0];
    String firstName = nameParts.length > 1 ? nameParts[1] : "";
    return new String[]{lastName, firstName};
}

    public static void main(String[] args) throws SQLException {
        PatientType patient = new PatientType();
        showmenu1();
    }
}
