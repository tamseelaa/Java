package week4.task2;

public class AmdahlLaw extends Thread {
    private int[] numbers =new int[100000];
    private int start, end;
    private long sum = 0;

    public AmdahlLaw(int[] arr, int start, int end) {
        this.numbers = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum= sum + numbers[i];
        }
    }
    public long getSum() {
        return sum;
    }
}

