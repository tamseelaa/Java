package OrientationTasks;

public class OrientationTask1_3Customer {
    private static int nextId = 1;
    private final int id;
    private long startTime;
    private long endTime;
    private Long serviceStartTime;
    private Long serviceEndTime;
    private Long serviceDurationNs;

    public OrientationTask1_3Customer() {this.id = nextId++;}

    public OrientationTask1_3Customer(long startTime) {
        this();
        this.startTime = startTime;}

    public int getId() {return id;}

    public long getStartTime() {return startTime;}

    public void setStartTime(long startTime) {this.startTime = startTime;}

    public long getEndTime() {return endTime;}

    public void setEndTime(long endTime) {this.endTime = endTime;}

    public long timeSpent() {return endTime - startTime;}

    public void markServiceStart(long t) {this.serviceStartTime = t;}

    public void markServiceEnd(long t) {
        this.serviceEndTime = t;
        if (serviceStartTime != null) {
            this.serviceDurationNs = serviceEndTime - serviceStartTime;
        }
    }

    public Long getServiceDurationNs() {
        return serviceDurationNs;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}