package src;

public class Room {
    private String roomNumber;
    private String roomType;
    private boolean isBooked;

    public Room(String roomNumber, String roomType, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = isBooked;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public boolean isBooked() { return isBooked; }

    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public void setBooked(boolean isBooked) { this.isBooked = isBooked; }
}
