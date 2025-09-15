package week5.task2;

import java.util.ArrayList;

public class LuggageCollectingBelt {
    private ArrayList<LuggageInfo> belt = new ArrayList<>();
    private int capacity = 100;   // normal

    // Can add special extended capacity for emergencies or special cases
    //private int specialExtendedCapacity = 200; // extra

    public synchronized boolean addLuggage(LuggageInfo luggage) {
        if (getTotalWeight() + luggage.getWeight() <= capacity) {
            belt.add(luggage);
            System.out.println("Added: " + luggage);
            return true;

        }
        System.out.println("Rejected (over capacity): " + luggage.getCustomerName());
        return false;
    }
    // Remove luggage by ticket number
    public synchronized boolean removeLuggage(int ticketNo) {
        for (LuggageInfo i : belt) {
            if (i.getTicketNo() == ticketNo) {
                belt.remove(i);
                System.out.println("Removed: " + i);
                return true;
            }
        }
        System.out.println("No luggage found with ticket: " + ticketNo);
        return false;
    }
    // current
    private synchronized int getTotalWeight() {
        int sum = 0;
        for (LuggageInfo i : belt) sum += i.getWeight();
        return sum;
    }

    // show all luggage info and total weight
    public synchronized void showLuggage() {
        System.out.println("\n--------------------------- Belt Contents -----------------------------");
        for (LuggageInfo i : belt) System.out.println(i);
        System.out.println("Total weight = " + getTotalWeight() + " lbs");
    }
}