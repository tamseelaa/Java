write a Calculator class that has the ability to sum positive integers. A negative integer should throw an exception


```
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
```

```

### Explanation of the Calculator class

 The `Calculator` class is designed to sum only positive integers.
 It has a private field `value` that stores the current sum.
 The `reset()` method sets `value` back to 0.
 The `add(int number)` method adds a positive integer to `value`. If a negative number is passed, it throws an `IllegalArgumentException`.
 The addition is performed using a for loop, incrementing `value` by 1 for each iteration, demonstrating loop usage.
 The `getValue()` method returns the current sum stored in `value`.
 The `main` method demonstrates how to use the class: it creates a `Calculator`, adds numbers, prints the value, resets, and prints again.
#### Code comments:
 `// Resets the calculator to zero.`: Explains the purpose of the `reset()` method.
 `// Adds a positive integer...`: Describes the `add()` method and its exception handling.
 `// Using a for loop...`: Notes the use of a loop for addition.
 `// Returns the current value...`: Describes the `getValue()` method.
 `// Demonstrates the usage...`: Explains the purpose of the `main` method.
```