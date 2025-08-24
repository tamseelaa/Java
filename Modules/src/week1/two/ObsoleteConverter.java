package week1.two;

import java.util.Scanner;

public class ObsoleteConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Conversion constants
        final int naula_per_leiviska = 20;
        final int luoti_per_naula = 32;
        final double grams_per_lauti = 13.28;

        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();

        //grams to total luoti
        double TotalLuoti = grams / grams_per_lauti;

        // Calculation
        int leiviska = (int) (TotalLuoti / (naula_per_leiviska * luoti_per_naula));
        int naula = (int) ((TotalLuoti - leiviska * naula_per_leiviska * luoti_per_naula) / luoti_per_naula);
        double luoti = TotalLuoti - leiviska * naula_per_leiviska * luoti_per_naula - naula * luoti_per_naula;

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.\n", grams, leiviska, naula, luoti);
    }
}