package ThreePhaseSimulation;

public class EventSimulatorStart {
    public static void main(String[] args) {
        EventList list = new EventList();

        // Generate events
        list.addEvent(new Event(EventType.ARRIVAL, 5));
        list.addEvent(new Event(EventType.ARRIVAL, 10));
        list.addEvent(new Event(EventType.EXIT, 15));

        // Print all events
        System.out.println("Initial event list:");
        list.printEvents();

        // Process next event
        Event next = list.getNextEvent();
        System.out.println("\nProcessing next event: " + next);

        // Print remaining
        System.out.println("\nRemaining events:");
        list.printEvents();
    }
}