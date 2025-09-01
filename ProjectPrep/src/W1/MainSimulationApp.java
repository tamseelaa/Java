package W1;
import java.util.Scanner;

public class MainSimulationApp {
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
                    OrientationTask2_Queue.main(new String[]{}); // run CLI
                    break;
                case "2":
                    ServiceSimulation.main(new String[]{}); // run service simulation
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