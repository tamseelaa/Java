package week4.task1;
import java.util.Random;

public class Odd implements Runnable {
    private final int max;
    private final Random rand = new Random();

    public Odd(int max) {
        this.max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i <= max; i += 2) {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(rand.nextInt(800)); // random pause for variability
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}