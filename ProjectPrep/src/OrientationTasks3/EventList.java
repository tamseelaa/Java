package OrientationTasks3;

import java.util.*;
class EventList {
    private List<Event> events = new ArrayList<>();

    public void add(Event e) {
        events.add(e);
    }

    public List<Event> getEvents() {
        return events;
    }
}
