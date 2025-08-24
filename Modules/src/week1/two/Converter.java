package week1.two;

import java.util.Scanner;
public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Temperature in Fahrenheit: ");

        double fahrenheit = Double.parseDouble(scanner.nextLine());
        double celsius = (fahrenheit - 32) * 5 / 9;

        System.out.printf("Temperature in Celsius: %.1f°C\n", celsius);
        scanner.close();
    }
}
