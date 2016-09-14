package musicapp.model;

/**
 * Created by ausias on 27/04/16.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@DatabaseTable(tableName = "Event")
public class Event {

    List<Event> events = null;

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private Date day;

    @DatabaseField
    private Time hour;

    @DatabaseField
    private float price;

    @DatabaseField
    private String observations;

    @DatabaseField
    private byte[] photo;

    public Event() {
        // all persisted classes must define a no-arg constructor with at least package visibility
        events = new ArrayList<Event>();
    }

    /**
     * Returns the Event's name
     * @return the Event's name
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getName() {
        return name;
    }

    /**
     * Set the Event's name
     * @param name is the Event's name
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Event's observations
     * @return the Event's observations
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Set the Event's localitzation
     * @param  observations  are the Event's observations
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    /**
     * Returns the day of the Event
     * @return  the day of the Event
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public Date getDay() {
        return day;
    }

    /**
     * Set the day of the Event
     * @param day is  the day of the Event
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setDay(Date day) {
        this.day = day;
    }

    /**
     * Returns  the hour of the Event
     * @return the Event's hour
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public Time getHour() {
        return hour;
    }

    /**
     * Set the hour of the Event
     * @param hour is the Event's hour
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setHour(Time hour) {
        this.hour = hour;
    }

    /**
     * Returns the Event's id
     * @return the Event's id
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Event's id
     * @return is the Event's id
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the Event's price
     * @return the Event's price
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set the Event's price
     * @param price is the Event's price
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setPrice(float price) {
        this.price = price;
    }


    /**
     * Get  Event's list
     * @return  return the Event's list
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Set the Event's list
     * @param events is the Event's list
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }


    /**
     * Add the Event to the Event's list
     * @param event is the Event
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public void addEvent(Event event) {
       events.add(event);
    }



    /**
     * Get the Event image
     * @return  photo is the Event's image
     * @author Débora López, Pili Bielsa, David Ferrer
     */
    public byte[] getPhoto() {
        return photo;
    }
}
