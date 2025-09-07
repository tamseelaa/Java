package week3.task1;

import java.io.*;
import java.util.Scanner;
//Generate a Fibonacci sequence of 60 numbers and write them to a CSV file.
public class FileWriting {
    public static void main(String[] args) {
        String filename = "fibonacci.csv";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Write Fibonacci sequence to file");
            System.out.println("2. Read Fibonacci sequence from file");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                    long a = 0, b = 1;
                    writer.write(a + "\n");
                    writer.write(b + "\n");

                    for (int i = 2; i < 60; i++) {
                        long c = a + b;
                        writer.write(c + "\n");
                        a = b;
                        b = c;
                    }
                    System.out.println("Fibonacci sequence written to " + filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file. Maybe write it first?");
                }

            } else if (choice == 3) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}
/*
try (FileWriter sentences = new FileWriter(filename)) {
                    long a = 0, b = 1;
                    sentences.write("Index,Value\n"); // header
                    for (int i = 0; i < 60; i++) {
                        sentences.write(i + "," + a + "\n");
                        long next = a + b;
                        a = b;
                        b = next;
                    }
                    System.out.println("Fibonacci sequence saved to " + filename);
                } catch (IOException e) {
                    e.printStackTrace();
*/