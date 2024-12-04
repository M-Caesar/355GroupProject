package src;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DataSeeder {

    private static final String URL = "jdbc:mysql://localhost:3306/HospitalManagement?useSSL=false&serverTimezone=America/New_York";
    private static final String USER = "root";
    private static final String PASSWORD = "SQL355%Grouppa55";
    private static final int NUMBER_OF_PATIENTS = 1000; // Number of patients to generate
    private static final int NUMBER_OF_PHYSICIANS = 10; // Number of physicians to generate

    private static final String[] firstNames = {
            "John", "Jane", "Alice", "Bob", "Carol", "Dave", "Eva", "Frank", "Grace", "Henry",
            "Liam", "Olivia", "Noah", "Emma", "Ava", "Sophia", "Mason", "Lucas", "Amelia", "Ethan",
            "Isabella", "James", "Alexander", "Charlotte", "Michael", "Benjamin", "Mia", "Elijah",
            "Daniel", "Emily", "Matthew", "Ella", "Samuel", "Victoria", "Nathan", "Chloe", "Oliver",
            "Madison", "Sebastian", "Jack", "Harper", "Jacob", "Leo", "Nora", "Sophie", "Abigail",
            "Nathaniel", "Zoe", "Logan", "Isla", "Jackson", "Evelyn", "Joshua", "Aiden", "Lily"
    };
    private static final String[] lastNames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
            "Rodriguez", "Martinez", "Wilson", "Anderson", "Taylor", "Thomas", "Hernandez",
            "Moore", "Martin", "Jackson", "Lee", "Perez", "Clark", "Walker", "Hall", "Allen",
            "Young", "Harris", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams",
            "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Roberts", "Turner", "Phillips",
            "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris",
            "Murphy", "Reed", "Cook", "Morgan", "Bell", "Bailey", "Rivera", "Cooper", "Richardson",
            "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James"
    };
    private static final String[] specialties = {
            "Cardiology", "Neurology", "Orthopedics", "Pediatrics", "General Practice",
            "Gastroenterology", "Pulmonology", "Dermatology", "Oncology", "Endocrinology"
    };
    private static final String[] diagnoses = {
            "Hypertension", "Migraine", "Fracture", "Asthma", "Diabetes", "Infection",
            "Allergy", "Depression", "Anxiety", "Arthritis", "Bronchitis", "Covid-19",
            "Heart Disease", "Kidney Stones", "Gastroenteritis", "Pneumonia", "Chronic Fatigue",
            "Obesity", "Liver Disease", "Pancreatitis", "COPD", "Stroke", "High Cholesterol",
            "Appendicitis", "Sleep Apnea", "Acid Reflux", "Gout", "Osteoporosis", "Vertigo",
            "Epilepsy", "Gallbladder Disease", "Skin Rash", "Ulcer", "Hepatitis", "Parkinson's Disease",
            "Tuberculosis", "Herniated Disc", "Multiple Sclerosis", "Fibromyalgia", "Scoliosis",
            "Hemorrhoids", "Conjunctivitis", "Sinusitis", "Ear Infection", "Seasonal Flu",
            "Bipolar Disorder", "Panic Disorder", "PTSD"
    };

    public static void main(String[] args) {
        Random random = new Random();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            seedPhysicians(conn, random);
            seedPatients(conn, random);
            System.out.println(NUMBER_OF_PATIENTS + " patients have been successfully added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void seedPhysicians(Connection conn, Random random) throws SQLException {
        String sql = "INSERT INTO Physicians (first_name, last_name, specialty) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < NUMBER_OF_PHYSICIANS; i++) {
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                String specialty = specialties[random.nextInt(specialties.length)];

                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setString(3, specialty);

                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println(NUMBER_OF_PHYSICIANS + " physicians have been successfully added to the database.");
        }
    }

    private static void seedPatients(Connection conn, Random random) throws SQLException {
        String sql = "INSERT INTO Patients (first_name, last_name, date_of_birth, gender, admission_date, discharge_date, room_number, attending_physician, diagnosis) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
                // Generating random patient data
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                Date dateOfBirth = new Date(System.currentTimeMillis() - ((random.nextInt(60) + 20) * 365L * 24 * 60 * 60 * 1000L + random.nextInt(365) * 24L * 60 * 60 * 1000L)); // Age 20-80 with more variation
                String gender = random.nextBoolean() ? "M" : "F";
                Date admissionDate = new Date(System.currentTimeMillis() - (random.nextInt(10) * 24L * 60L * 60L * 1000L)); // Past 10 days
                Date dischargeDate = random.nextBoolean() ? new Date(admissionDate.getTime() + (random.nextInt(5) * 24L * 60L * 60L * 1000L)) : null; // Within 5 days or null
                int roomNumber = random.nextInt(100) + 1; // Rooms 1-100 for more diversity
                int attendingPhysician = random.nextInt(NUMBER_OF_PHYSICIANS) + 1; // Physicians 1-10 for more diversity
                String diagnosis = diagnoses[random.nextInt(diagnoses.length)];

                // Setting values for SQL statement
                pstmt.setString(1, firstName);
                pstmt.setString(2, lastName);
                pstmt.setDate(3, dateOfBirth);
                pstmt.setString(4, gender);
                pstmt.setDate(5, admissionDate);
                if (dischargeDate != null) {
                    pstmt.setDate(6, dischargeDate);
                } else {
                    pstmt.setNull(6, java.sql.Types.DATE);
                }
                pstmt.setInt(7, roomNumber);
                pstmt.setInt(8, attendingPhysician);
                pstmt.setString(9, diagnosis);

                // Add to batch
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }
}
