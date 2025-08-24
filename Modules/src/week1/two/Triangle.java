package week1.two;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the base side: ");
        double leg1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the length of the perpendicular side: ");
        double leg2 = Double.parseDouble(scanner.nextLine());

        double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
        System.out.printf("The length of the hypotenuse is: %.2f%n", hypotenuse);

        scanner.close();
    }
}