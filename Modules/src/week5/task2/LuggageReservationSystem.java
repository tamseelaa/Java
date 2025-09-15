package week5.task2;

public class LuggageReservationSystem {
    public static void main(String[] args) {
        LuggageCollectingBelt belt = new LuggageCollectingBelt();

        // Thread to add luggage
        Thread adder = new Thread(() -> {
            belt.addLuggage(new LuggageInfo("Alice", 30, 1010));
            sleep(50);
            belt.addLuggage(new LuggageInfo("Bob", 40, 1011));
            sleep(50);
            belt.addLuggage(new LuggageInfo("Charlie", 50, 1012));
            sleep(50);
            belt.addLuggage(new LuggageInfo("David", 60, 1013));
            sleep(50);
            belt.addLuggage(new LuggageInfo("Eve", 20, 1014));
        });

        // Thread to remove luggage
        Thread remover = new Thread(() -> {
            sleep(100);
            belt.removeLuggage(1011); // remove Bob's luggage
        });

        // Thread to view belt periodically
        Thread viewer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    belt.showLuggage();
                    sleep(70);
                }
            }
        });

        // Start all threads
        adder.start();
        remover.start();
        viewer.start();

        // Wait
        try {
            adder.join();
            remover.join();
            viewer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}







  /*  public static void main(String[] args) {
        LuggageCollectingBelt belt = new LuggageCollectingBelt();

        // Add luggage
        belt.addLuggage(new LuggageInfo("Alice", 30, 101));
        belt.addLuggage(new LuggageInfo("Bob", 40, 102));
        belt.addLuggage(new LuggageInfo("Charlie", 50, 103)); // may exceed capacity

        // Show current belt
        belt.showLuggage();

        // Remove a luggage
        belt.removeLuggage(102); // remove Bob's luggage

        // Show updated belt
        belt.showLuggage();

        // Try adding more luggage
        belt.addLuggage(new LuggageInfo("David", 60, 104));

        // Final belt contents
        belt.showLuggage();

        belt.addLuggage(new LuggageInfo("Eve", 120, 105));
    }
}
*/