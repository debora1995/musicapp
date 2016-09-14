package musicapp.persistence.ormlite;


import java.util.List;

import musicapp.model.Event;

/**
 * Created by ausias on 11/05/16.
 */
public interface EventDao {

        public List<Event> getAllEvents();
        public Event getEvent(int id);
        public void updateEvent(Event usr);
        public void deleteEvent(Event usr);

}
