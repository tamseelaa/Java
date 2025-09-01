package OrientationTasks;
import java.util.Scanner;

public class OrientationTask1_6MainSimulationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Main Simulation Menu ===");
            System.out.println("1. Run Queue CLI (manual enqueue/dequeue)");
            System.out.println("2. Run Service System Simulation (auto-generated customers)");
            System.out.println("0. Quit");
            System.out.print("Choice: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    OrientationTask1_4Queue.main(new String[]{});
                    break;
                case "2":
                    OrientationTask1_6ServiceSimulation.main(new String[]{});
                    break;
                case "0":
                    System.out.println("Exiting MainSimulationApp.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}