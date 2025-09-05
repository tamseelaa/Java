package OrientationTasks3;
import java.util.LinkedList;
import java.util.*;
public class ServicePoint {
    private Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer c) {
        queue.add(c);
    }

    public Customer serve(double currentTime) {
        if (queue.isEmpty()) return null;
        Customer c = queue.poll();
        c.setEndTime((long) currentTime);
        return c;
    }
    public static void main(String[] args) {
        ServicePoint sp = new ServicePoint();
        sp.addCustomer(new Customer(0));
        sp.addCustomer(new Customer(3));

        Customer c = sp.serve(5);
        System.out.println(c);
    }
}