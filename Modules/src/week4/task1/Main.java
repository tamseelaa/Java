package week4.task1;

public class Main {
    public static void main(String[] args) {
        int max = 20;

        Thread oddThread = new Thread(new Odd(max));
        Thread evenThread = new Thread(new Even(max));

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}