package OrientationTasks3;

class Event {
    String type;
    double time;

    public Event(String type, double time) {
        this.type = type;
        this.time = time;
    }//

    public String toString() {
        return String.format("Event[%s @ %.2f]", type, time);
    }
}


