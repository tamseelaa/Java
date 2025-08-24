package week1.one;


import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.print("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());
        System.out.print("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());
        int sum = first + second + third;
        double average= sum/3.0;
        System.out.println("The sum of the numbers is " + sum);
        System.out.println("The multiple of the numbers is " + first * second * third);
        System.out.printf("The average of the numbers is %.13f\n" , average);
    }
}