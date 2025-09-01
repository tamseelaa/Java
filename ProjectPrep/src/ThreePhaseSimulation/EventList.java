package ThreePhaseSimulation;

import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> queue = new PriorityQueue<>();

    public void addEvent(Event e) {
        queue.add(e);
    }

    public Event getNextEvent() {
        return queue.poll(); // retrieves earliest event
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printEvents() {
        queue.stream()
                .sorted()
                .forEach(System.out::println);
    }
}