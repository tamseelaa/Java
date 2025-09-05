package OrientationTasks4;

import java.util.*;

public class ArrivalProcess {
    private Random rand;
    private String eventType; // e.g., "ARRIVAL"
    private double lambda;    // mean interarrival time
    private Clock clock;

    public ArrivalProcess(String eventType, double lambda) {
        this.rand = new Random();
        this.eventType = eventType;
        this.lambda = lambda;
        this.clock = Clock.getInstance();
    }

    private double generateInterArrival() {
        // Exponential distribution: -ln(U)/λ
        return -Math.log(1 - rand.nextDouble()) / lambda;
    }

    public void generateEvents(EventList list, int n) {
        double t = clock.getTime();
        for (int i = 0; i < n; i++) {
            double inter = generateInterArrival();
            t += inter;
            Event e = new Event(eventType, t);
            list.add(e);
            clock.setTime(t);
        }
    }
}