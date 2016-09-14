package musicapp.persistence.ormlite;

import java.util.ArrayList;
import java.util.List;

import musicapp.model.Event;

/**
 * Created by ausias on 11/05/16.
 */
public abstract class  EventDaoImpl implements EventDao  {

    //list is working as a database
    List<Event> Events;

    public EventDaoImpl(){
        Events = new ArrayList<Event>();
        Event e1 = new Event();
        Event e2 = new Event();
        Events.add(e1);
        Events.add(e2);
    }
    @Override
    public void deleteEvent(Event Event) {
        Events.remove(Event.getId());
        System.out.println("Event: Roll No " + Event.getId() + ", deleted from database");
    }

    //retrive list of Events from the database
    @Override
    public List<Event> getAllEvents() {
        return Events;
    }

    @Override
    public Event getEvent(int rollNo) {
        return Events.get(rollNo);
    }

    @Override
    public void updateEvent(Event Event) {
        Events.get(Event.getId()).setName(Event.getName());
        System.out.println("Event: Roll No " + Event.getId() + ", updated in the database");
    }
}


