package week1.four;

import java.util.Arrays;
import java.util.Scanner;

public class SubArraySum_GoodButApartFromExerciseQuestion_CreatedByMisunderstanding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arrayScare = new int[size];

        System.out.println("Enter the integers into the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter Indice " + (i + 1) + ": ");
            int num = scanner.nextInt();

            arrayScare[i] = num;
        }
        System.out.println("Array : "+ Arrays.toString(arrayScare));

        //""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
        // above we made a simple array value storing system and below we will ask user about
        //SubArray starting and ending form, and create a system to sum them after knowing.

        System.out.println("\nNow, please enter the starting and ending Indice of the subarray" +
                " for which you want to calculate the sum");
        System.out.print("\nEnter starting Indice number of array : ");
        int start = scanner.nextInt();
        System.out.print("Enter ending  Indice number of array : ");
        int end = scanner.nextInt();
        int sum=0;
        int j=0;
        int[] check = new int[end - start+1];
        if (start < 1 || end > size || start > end) {
            System.out.println("Invalid indices! Please enter values between 1 and " + size);
            return;
        }
        else{
            for(int i=start-1; i<end; i++){
                sum+=arrayScare[i];
                check[j]= arrayScare[i];
                j++;
                }
        }
        System.out.println("The sum of Subarray is "+sum);
        System.out.println(Arrays.toString(check));
    }
}

