package OrientationTasks3;
import java.util.*;

public class AgeDistributionTest {
    public static void main(String[] args) {
        // Age distribution (hard-coded as per assignment)
        int[] ages = {20, 21, 22, 23};
        double[] probs = {0.3, 0.4, 0.2, 0.1}; // must sum to 1

        // Build cumulative distribution
        double[] cdf = new double[probs.length];
        cdf[0] = probs[0];
        for (int i = 1; i < probs.length; i++) {
            cdf[i] = cdf[i - 1] + probs[i];
        }

        Random rand = new Random();
        int N = 1000;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < N; i++) {
            double r = rand.nextDouble();
            int chosenAge = -1;
            for (int j = 0; j < cdf.length; j++) {
                if (r < cdf[j]) {
                    chosenAge = ages[j];
                    break;
                }
            }
            counts.put(chosenAge, counts.getOrDefault(chosenAge, 0) + 1);
        }

        // Print result
        System.out.println("Sampled age distribution from " + N + " students:");
        for (int age : ages) {
            System.out.printf("Age %d → %d (%.2f%%)\n",
                    age,
                    counts.getOrDefault(age, 0),
                    counts.getOrDefault(age, 0) * 100.0 / N);
        }
    }
}