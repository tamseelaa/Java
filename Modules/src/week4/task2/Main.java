package week4.task2;
import java.util.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: " + cores);

        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);
        }

        int chunk = numbers.length / cores;
        AmdahlLaw[] threads = new AmdahlLaw[cores];

        // Create and start threads chunk by chunk
        for (int i = 0; i < cores; i++) {
            int start = i * chunk;
            int end = (i == cores - 1) ? numbers.length : start + chunk; //
            threads[i] = new AmdahlLaw(numbers, start, end);
            threads[i].start();
        }

        // Waiting for threads till it has sum
        long totalSum = 0;
        for (AmdahlLaw thread : threads) {
            thread.join();
            totalSum += thread.getSum();
        }

        System.out.println("Total sum: " + totalSum);
    }
}