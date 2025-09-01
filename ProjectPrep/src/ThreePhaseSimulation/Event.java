package ThreePhaseSimulation;

public class Event implements Comparable<Event> {
    private EventType type;
    private int time;

    public Event(EventType type, int time) {
        this.type = type;
        this.time = time;
    }

    public EventType getType() { return type; }
    public int getTime() { return time; }

    @Override
    public int compareTo(Event other) {
        return this.time - other.time; // earlier events first
    }

    @Override
    public String toString() {
        return "[" + type + " @ " + time + "]";
    }
}