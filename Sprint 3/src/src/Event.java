package src;

import java.time.LocalDateTime;
//Class for creating event objects
public class    Event {
    private String eventName;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventTime; // date and time of event
    private String eventRoom;

    //default constructor
    public Event() {
        this.eventName = "";
        this.eventType = "";
        this.eventDescription = "";
        this.eventTime = null;
        this.eventRoom = "";
    }

    //initialized constructor
    public Event(String eventName, String eventType, String eventDescription, LocalDateTime eventTime, String eventRoom) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventRoom = eventRoom;
    }
    //getters
    public String getEventName() {return eventName;}
    public String getEventType() {return eventType;}
    public String getEventDescription() {return eventDescription;}
    public LocalDateTime getEventTime() {return eventTime;}
    public String getEventRoom() {return eventRoom;}
    //setters
    public void setEventName(String eventName) {this.eventName = eventName;}
    public void setEventType(String eventType) {this.eventType = eventType;}
    public void setEventDescription(String eventDescription) {this.eventDescription = eventDescription;}
    public void setEventTime(LocalDateTime eventTime) {this.eventTime = eventTime;}
    public void setEventRoom(String eventRoom) {this.eventRoom = eventRoom;}

    //print method for current patient event information
    public void printEvent() {
        System.out.println("Patient Event: " + this.getEventName() + " occuring at " + this.getEventTime());
        System.out.println("Type: " + this.getEventType());
        System.out.println("Description: " + this.getEventDescription());
        System.out.println("Room: " + this.getEventRoom());
        System.out.println("----------------------------------------");
    }

    //print function for chosen event
    public void printChosenEvent(Event chosenEvent) {
        System.out.println("Patient Event: " + chosenEvent.getEventName() + " occuring at " + chosenEvent.getEventTime());
        System.out.println("Type: " + chosenEvent.getEventType());
        System.out.println("Description: " + chosenEvent.getEventDescription());
        System.out.println("Room: " + chosenEvent.getEventRoom());
    }
}
