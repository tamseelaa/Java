package week5.task1;
public class WorkingSystem {
    public static void main(String[] args) {

        int[][] customerData = {
                {1, 2}, {2, 1}, {3, 3}, {4, 1}, {5, 2},
                {6, 2}, {7, 1}, {8, 1}, {9, 3}, {10, 3},
                {11, 2}, {12, 4}, {13,1}};

        for (int[] element : customerData) {
            int customerNo = element[0];
            int tickets = element[1];
            new Thread(new TicketReservationSystem(customerNo, tickets)).start();
        }
    }
}
/*    public static void main(String[] args) {
        Thread t1 = new Thread(new TicketReservationSystem(1, 2));
        Thread t2 = new Thread(new TicketReservationSystem(2, 1));
        Thread t3 = new Thread(new TicketReservationSystem(3, 3));
        Thread t4 = new Thread(new TicketReservationSystem(4, 1));
        Thread t5 = new Thread(new TicketReservationSystem(5, 2));
        Thread t6 = new Thread(new TicketReservationSystem(6, 2));
        Thread t7 = new Thread(new TicketReservationSystem(7, 1));
        Thread t8 = new Thread(new TicketReservationSystem(8, 1));
        Thread t9 = new Thread(new TicketReservationSystem(9, 3));
        Thread t10 = new Thread(new TicketReservationSystem(10, 3));

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start();
        t6.start(); t7.start(); t8.start(); t9.start(); t10.start();
    }*/