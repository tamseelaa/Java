package W1;

public class OrientationTask1_4 {
    public static void main(String[] args) throws InterruptedException {
        Customer c1 = new Customer(System.nanoTime());
        Thread.sleep(10); // simulate doing something
        c1.setEndTime(System.nanoTime());


        System.out.println("Customer id = " + c1.getId());
        long spentNs = c1.timeSpent();
        System.out.println("Time spent (ns) = " + spentNs);
        System.out.println("Time spent (ms) ≈ " + toMillis(spentNs));
    }


    private static long toMillis(long ns) {
        return java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(ns);
    }
}