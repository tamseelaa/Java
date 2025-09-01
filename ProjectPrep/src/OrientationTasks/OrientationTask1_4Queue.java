package OrientationTasks;

import java.util.LinkedList;
import java.util.Scanner;


public class OrientationTask1_4Queue {
    public static void main(String[] args) {
        LinkedList<OrientationTask1_3Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Commands: (e)nqueue, (d)equeue, (p)rint, (q)uit");

        while (true) {
            System.out.print("> ");
            String cmd = sc.nextLine().trim().toLowerCase();
            switch (cmd) {
                case "e":
                case "enqueue": {
                    OrientationTask1_3Customer c = new OrientationTask1_3Customer();
                    c.setStartTime(System.nanoTime()); // enqueue timestamp
                    queue.addFirst(c); // FIFO with addFirst/removeLast
                    System.out.println("Enqueued customer " + c.getId() + ". Queue size = " + queue.size());
                    break;
                }
                case "d":
                case "dequeue": {
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                        break;
                    }
                    OrientationTask1_3Customer c = queue.removeLast(); // oldest leaves first
                    c.setEndTime(System.nanoTime());
                    long waitedNs = c.timeSpent();
                    System.out.println("Dequeued customer " + c.getId() +
                            ", waited ≈ " + toMillis(waitedNs) + " ms (" + waitedNs + " ns)");
                    break;
                }
                case "p":
                case "print": {
                    System.out.print("Queue (oldest → newest): ");
                    if (queue.isEmpty()) {
                        System.out.println("<empty>");
                    } else {
                        for (int i = queue.size() - 1; i >= 0; i--) {
                            System.out.print(queue.get(i).getId());
                            if (i > 0) System.out.print(" ← ");
                        }
                        System.out.println();
                    }
                    break;
                }
                case "q":
                case "quit":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Unknown command. Try e/d/p/q.");
            }
        }
    }
    private static long toMillis(long ns) {
        return java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(ns);
    }
}
