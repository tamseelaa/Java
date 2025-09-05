package OrientationTasks3;

public class Clock {
    private static Clock instance;
    private double currentTime;

    private Clock() {
        this.currentTime = 0.0;
    }

    public static synchronized Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(double t) {
        this.currentTime = t;
    }

    public double getTime() {
        return currentTime;
    }

    public void advance(double delta) {
        this.currentTime += delta;
    }
}

// Test program
class ClockTest {
    public static void main(String[] args) {
        Clock c = Clock.getInstance();
        System.out.println("Time = " + c.getTime());
        c.advance(5);
        System.out.println("Time = " + c.getTime());
        c.setTime(42);
        System.out.println("Time = " + c.getTime());

        Clock c2 = Clock.getInstance();
        System.out.println("Same instance? " + (c == c2));
    }
}