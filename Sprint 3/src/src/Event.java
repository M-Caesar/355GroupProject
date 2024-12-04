package src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
//Class for creating event objects
public class    Event {
    private String eventName;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventStartTime; // date and time of event
    private LocalDateTime eventEndTime;
    //private LocalDateTime eventStartDate;
    //private LocalDateTime eventEndDate;
    private String eventRoom;

    //default constructor
    public Event() {
        this.eventName = "";
        this.eventType = "";
        this.eventDescription = "";
        this.eventStartTime = null;
        this.eventEndTime = null;
       // this.eventStartDate = null;
        //this.eventEndDate = null;
        this.eventRoom = "";
    }

    //initialized constructor
    public Event(String eventName, String eventType, String eventDescription, LocalDateTime eventSTime, LocalDateTime eventETime, String eventRoom) {
        this.eventName = eventName;
        this.eventType = eventType;
        this.eventStartTime = eventSTime;
        this.eventEndTime = eventETime;
        this.eventDescription = eventDescription;
        this.eventRoom = eventRoom;
    }
    //getters
    public String getEventName() {return eventName;}
    public String getEventType() {return eventType;}
    public String getEventDescription() {return eventDescription;}
    public LocalDateTime getEventStartTime() {return eventStartTime;}
    public LocalDateTime getEventEndTime() {return eventEndTime;}
    public String getEventRoom() {return eventRoom;}
    //setters
    public void setEventName(String eventName) {this.eventName = eventName;}
    public void setEventType(String eventType) {this.eventType = eventType;}
    public void setEventDescription(String eventDescription) {this.eventDescription = eventDescription;}
    public void setEventStartTime(LocalDateTime eventStartTime) {this.eventStartTime = eventStartTime;}
    public void setEventEndTime(LocalDateTime eventEndTime) {this.eventEndTime = eventEndTime;}
    public void setEventRoom(String eventRoom) {this.eventRoom = eventRoom;}

    //print method for current patient event information
    public void printEvent() {
        System.out.println("Patient Event: " + this.getEventName() + " occuring at " + this.getEventStartTime());
        System.out.println("Type: " + this.getEventType());
        System.out.println("Description: " + this.getEventDescription());
        System.out.println("Room: " + this.getEventRoom());
        System.out.println("----------------------------------------");
    }

    //print function for chosen event
    public void printChosenEvent(Event chosenEvent) {
        System.out.println("Patient Event: " + chosenEvent.getEventName() + " occuring at " + chosenEvent.getEventStartTime());
        System.out.println("Type: " + chosenEvent.getEventType());
        System.out.println("Description: " + chosenEvent.getEventDescription());
        System.out.println("Room: " + chosenEvent.getEventRoom());
    }

    public int getEventStartYear() {
        return eventStartTime != null ? eventStartTime.getYear() : 0;
    }

    public int getEventStartMonth() {
        return eventStartTime != null ? eventStartTime.getMonthValue() : 0;
    }

    public int getEventStartDay() {
        return eventStartTime != null ? eventStartTime.getDayOfMonth() : 0;
    }

    public int getEventStartHour() {
        return eventStartTime != null ? eventStartTime.getHour() : 0;
    }

    public int getEventStartMinute() {
        return eventStartTime != null ? eventStartTime.getMinute() : 0;
    }

    public int getEventStartSecond() {
        return eventStartTime != null ? eventStartTime.getSecond() : 0;
    }

    public String getFormattedEventStartDate() {
        if (eventStartTime != null) {
            int year = eventStartTime.getYear();
            int month = eventStartTime.getMonthValue();
            int day = eventStartTime.getDayOfMonth();
            return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
        }
        return null;
    }

    public String getFormattedEventStartTime() {
        if (eventStartTime != null) {
            int hour = eventStartTime.getHour();
            int minute = eventStartTime.getMinute();
            int second = eventStartTime.getSecond();
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
        return null;
    }
    // Methods to extract End Date and Time
    public int getEventEndYear() {
        return eventEndTime != null ? eventEndTime.getYear() : 0;
    }

    public int getEventEndMonth() {
        return eventEndTime != null ? eventEndTime.getMonthValue() : 0;
    }

    public int getEventEndDay() {
        return eventEndTime != null ? eventEndTime.getDayOfMonth() : 0;
    }

    public int getEventEndHour() {
        return eventEndTime != null ? eventEndTime.getHour() : 0;
    }

    public int getEventEndMinute() {
        return eventEndTime != null ? eventEndTime.getMinute() : 0;
    }

    public int getEventEndSecond() {
        return eventEndTime != null ? eventEndTime.getSecond() : 0;
    }

    public String getFormattedEventEndDate() {
        if (eventEndTime != null) {
            int year = eventEndTime.getYear();
            int month = eventEndTime.getMonthValue();
            int day = eventEndTime.getDayOfMonth();
            return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
        }
        return null;
    }

    public String getFormattedEventEndTime() {
        if (eventEndTime != null) {
            int hour = eventEndTime.getHour();
            int minute = eventEndTime.getMinute();
            int second = eventEndTime.getSecond();
            return String.format("%02d:%02d:%02d", hour, minute, second);
        }
        return null;
    }
}
