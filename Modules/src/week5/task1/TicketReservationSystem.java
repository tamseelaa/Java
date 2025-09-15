package week5.task1;

public class TicketReservationSystem implements Runnable {
    private static int availableTickets;
    private int reservedTickets;
    private int ticketBooker;
    private int CustomerNo;

    public TicketReservationSystem(int CustomerNo,int ticketBooker) {
        this.ticketBooker = ticketBooker;
        this.reservedTickets = 0;
        this.availableTickets = 10;
        this.CustomerNo = CustomerNo;
    }
    @Override
    public void run() {
        synchronized (TicketReservationSystem.class){
            if (ticketBooker > availableTickets) {
                System.out.println("Customer "+CustomerNo+" Couldn't reserved "+ ticketBooker+ "tickets.");
            } else {
                reservedTickets += ticketBooker;
                availableTickets -= ticketBooker;
                System.out.println("Customer "+CustomerNo+" reserved "+ ticketBooker+ "tickets.");
            }
        }
    }
}
