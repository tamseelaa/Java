package week3.task3;

public class Calculator {
    private int value;

    // Resets the calculator to zero.
    public void reset() {
        value = 0;
    }

    // Adds a positive integer to the calculator. Throws IllegalArgumentException if the number is negative.
    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        // Using a for loop to add 1, number times (demonstrating loop structure)
        for (int i = 0; i < number; i++) {
            value++;
        }
    }

    // Returns the current value of the calculator.
    public int getValue() {
        return value;
    }

    // Demonstrates the usage of the Calculator class.
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5);
        calc.add(10);
        System.out.println("Current Value: " + calc.getValue());
        calc.reset();
        System.out.println("Value after reset: " + calc.getValue());
    }
}

