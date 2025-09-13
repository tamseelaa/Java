package week4.task1;

import java.util.Random;

public class Even implements Runnable {
    private final int max;
    private final Random rand = new Random();

    public Even(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 2; i <= max; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(rand.nextInt(500)); // random pause for variability
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}