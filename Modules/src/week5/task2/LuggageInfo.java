package week5.task2;

public class LuggageInfo {
    String customerName;
    private int weight;
    private int ticketNo;
    public LuggageInfo(String customerName, int weight, int ticketNo) {
        this.customerName = customerName;
        this.weight = weight;
        this.ticketNo = ticketNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getWeight() {
        return weight;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    @Override
    public String toString() {
        return customerName + " | Ticket: " + ticketNo + " | " + weight + " lbs";
    }
}