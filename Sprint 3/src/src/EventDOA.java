package src;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class EventDOA {

    // Method to get all events from the database
    public static Event[] getAllEvents() {
        List<Event> events = new ArrayList<>(); // Temporary list to hold events
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Establish a database connection (adjust credentials as needed)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "355Password!"); // Censored password

            // 2. Create a statement object to send the SQL query
            statement = connection.createStatement();

            // 3. Execute the SQL query to select all events
            String sql = "SELECT event_id, event_name, event_type, event_description, event_start_time, event_end_time, event_room FROM events";
            resultSet = statement.executeQuery(sql);

            // 4. Process the result set and create Event objects
            while (resultSet.next()) {
                // Extract data from the result set
                int eventId = resultSet.getInt("event_id");
                String eventName = resultSet.getString("event_name");
                String eventType = resultSet.getString("event_type");
                String eventDescription = resultSet.getString("event_description");
                LocalDateTime eventStartTime = resultSet.getTimestamp("event_start_time").toLocalDateTime();
                LocalDateTime eventEndTime = resultSet.getTimestamp("event_end_time").toLocalDateTime();
                String eventRoom = resultSet.getString("event_room");

                // Create an Event object and add it to the list
                Event event = new Event(eventName, eventType, eventDescription, eventStartTime, eventEndTime, eventRoom);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } finally {
            // 5. Close resources (resultSet, statement, and connection)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Convert the list to an array and return it
        return events.toArray(new Event[0]);
    }


    public static void addEvent(Event event) {
        // SQL statement for inserting a new event
        String sql = "INSERT INTO events (event_name, event_type, event_description, event_start_time, event_end_time, event_room) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagement", "root", "355Password!");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Validate LocalDateTime format before inserting into DB
            /*if (event.getEventStartTime() == null || event.getEventEndTime() == null) {
                throw new IllegalArgumentException("Event start time or end time is not valid.");
            } */

            // Set the values for the SQL query
            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventType());
            pstmt.setString(3, event.getEventDescription());
            pstmt.setTimestamp(4, Timestamp.valueOf(event.getEventStartTime())); // Convert LocalDateTime to Timestamp
            pstmt.setTimestamp(5, Timestamp.valueOf(event.getEventEndTime()));   // Convert LocalDateTime to Timestamp
            pstmt.setString(6, event.getEventRoom());

            // Execute the insert statement
            pstmt.executeUpdate();
            System.out.println("Event added successfully to the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // Handle invalid date or time format
            System.err.println("Error adding event: " + e.getMessage());
        }
    }

}
