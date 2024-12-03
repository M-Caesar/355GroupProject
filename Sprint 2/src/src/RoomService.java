package src;
import src.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    /**
     * Retrieves room availability based on the specified start time and event type.
     */
    public List<Room> getRoomAvailability(Timestamp start, String eventType) {
        String query = """
            SELECT r.room_number, r.room_type,
                   CASE
                     WHEN e.start_time <= ? AND e.end_time >= ? THEN true
                     ELSE false
                   END AS is_booked
            FROM rooms r
            LEFT JOIN events e ON r.room_number = e.room_number
            WHERE (e.event_name = ? OR e.event_name IS NULL)
            GROUP BY r.room_number, r.room_type;
        """;

        List<Room> roomList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, start);
            stmt.setTimestamp(2, start);
            stmt.setString(3, eventType);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Room room = new Room(
                            rs.getString("room_number"),
                            rs.getString("room_type"),
                            rs.getBoolean("is_booked")
                    );
                    roomList.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    /**
     * Books a room for a specified event and patient.
     */
    public boolean bookRoom(String roomNumber, String eventName, String patientID, Timestamp start, Timestamp end) throws SQLException {
        String query = """
            INSERT INTO events (room_number, event_name, patient_mrn, start_time, end_time)
            VALUES (?, ?, ?, ?, ?)
        """;

        // Adjust start and end times to account for buffer (30 minutes)
        Timestamp adjustedStart = new Timestamp(start.getTime() - 30 * 60 * 1000);
        Timestamp adjustedEnd = new Timestamp(end.getTime() + 30 * 60 * 1000);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, roomNumber);
            stmt.setString(2, eventName);
            stmt.setString(3, patientID);
            stmt.setTimestamp(4, adjustedStart);
            stmt.setTimestamp(5, adjustedEnd);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-throw exception to ensure proper handling by caller
        }
    }
}
