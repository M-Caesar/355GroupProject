package src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//Schedule class designed to hold multiple event class objects
public class Schedule {
    //Holding them in a list
    private List<Event> events;
    public Schedule() {
        this.events = new ArrayList<>();
    }
    //method for adding a new event
    public void addEvent(Event newevent) {
        this.events.add(newevent);
    }
    //method for removing a specific event
    public void removeEvent(Event newevent) {
        this.events.remove(newevent);
    }
    //returns events in this schedule
    public List<Event> getEvents() {
        return this.events;
    }
    //prints all events in the schedule
    public void printAllEvents() {
        List<Event> result = new ArrayList<>();
        for (Event event : this.events) {
            event.printEvent();
        }
    }
    //Searches list and returns events that match by specifc date
    public List<Event> getEventbyDate(LocalDateTime date) {
        List<Event> result = new ArrayList<>();
        for (Event event : this.events) {
            if(event.getEventTime().toLocalDate().equals(date)) {
                result.add(event);
            }
        }
        return result;
    }
}
