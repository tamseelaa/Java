package W1;

import java.util.LinkedList;

public class ServicePoint {
    private final LinkedList<Customer> queue = new LinkedList<>();
    private final String name;

    public ServicePoint(String name) {
        this.name = name;
    }

    public void addToQueue(Customer c) {
        c.setStartTime(System.nanoTime());
        queue.addFirst(c); // FIFO via addFirst/removeLast
        System.out.println("[" + name + "] Enqueued customer " + c.getId() + ". Queue size = " + queue.size());
    }

    public Customer removeFromQueue() {
        if (queue.isEmpty()) return null;
        return queue.removeLast();
    }

    public void serve() {
        System.out.println("[" + name + "] Starting service...");
        int servedCount = 0;
        long totalServiceNs = 0;

        while (!queue.isEmpty()) {
            Customer c = removeFromQueue();
            if (c == null) break;

            long serviceStart = System.nanoTime();
            c.markServiceStart(serviceStart);

            // random service time (0.5–2.0s)
            long serviceTimeMs = 500 + (long)(Math.random() * 1500);

            try {
                Thread.sleep(serviceTimeMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            long serviceEnd = System.nanoTime();
            c.markServiceEnd(serviceEnd);

            long waitNs = c.getServiceDurationNs();
            long responseNs = (c.getServiceDurationNs() != null ? c.getServiceDurationNs() : 0)
                    + (serviceStart - c.getStartTime());

            System.out.println("Customer " + c.getId() +
                    " served in ≈ " + toMillis(waitNs) + " ms, response time ≈ " + toMillis(responseNs) + " ms");

            if (c.getServiceDurationNs() != null) {
                totalServiceNs += c.getServiceDurationNs();
                servedCount++;
            }
        }

        if (servedCount > 0) {
            double avgServiceMs = toMillis(totalServiceNs) / (double) servedCount;
            System.out.println("[" + name + "] Average service time ≈ " + avgServiceMs + " ms over " + servedCount + " customers.");
        } else {
            System.out.println("[" + name + "] No customers served.");
        }
        System.out.println("[" + name + "] Service finished.");
    }

    private long toMillis(long ns) {
        return java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(ns);
    }
}