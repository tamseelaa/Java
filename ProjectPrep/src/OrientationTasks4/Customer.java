package OrientationTasks4;

public class Customer {
    private static int idCounter = 0;   // auto-increment ID
    private int id;
    private long arrivalTime;
    private long endTime;

    public Customer(long arrivalTime) {
        this.id = ++idCounter;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getTimeInSystem() {
        return endTime - arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer " + id +
                " (arrival=" + arrivalTime +
                ", end=" + endTime +
                ", total=" + getTimeInSystem() + ")";
    }
}
