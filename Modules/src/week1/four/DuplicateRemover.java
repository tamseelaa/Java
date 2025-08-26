package week1.four;

import java.util.Scanner;

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        int uniqueCount = 0; // Essential trick used for the program, it's used as (counter for index) to identify duplication in the array

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = scanner.nextInt();

            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (array[j] == num) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                array[uniqueCount] = num;
                uniqueCount++;
            }
        }

        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(array[i] + " ");
        }
    }
}