package edu.byui.apj.week1;

/**
 * The FibonacciSequenceWithTwist class generates and prints a sequence of Fibonacci numbers
 * with a twist: even numbers in the sequence are marked with an asterisk (*).
 *
 * <p>The program accepts a single command-line argument to specify the number of Fibonacci
 * numbers to generate. If the argument is invalid or missing, an error is displayed.</p>
 */

public class FibonacciSequenceWithTwist {

    /**
     * Generates and prints the Fibonacci sequence with a twist.
     * Even Fibonacci numbers are marked with an asterisk (*).
     *
     * @param numberCount the number of Fibonacci numbers to generate and print.
     *                    Must be a positive integer.
     */
    private static void WriteFibonacciSequence(int numberCount) {
        long num1 = 0, num2 = 1, temp;

        System.out.print(num1);
        if (numberCount == 1) return;
        System.out.print(", ");

        System.out.print(num2);
        System.out.print(", ");

        for (int i = 0; i < numberCount-2; i++) {
            temp = num1;
            num1 = num2;
            num2 += temp;

            System.out.print(num2);
            if (num2 % 2 == 0) {
                System.out.print("*");
            }
            System.out.print(", ");
        }
        System.out.println("\b\b ");

    }

    /**
     * The main method serves as the entry point for the program.
     * It processes command-line arguments, validates input, and invokes the Fibonacci sequence generator.
     *
     * @param args command-line arguments. The first and only argument should be a positive integer.
     */
    public static void main(String[] args) {
        try {
            if (args.length != 1) throw new NumberFormatException();
            int n = Integer.parseInt(args[0]);
            if (n <= 0) throw new NumberFormatException();

            WriteFibonacciSequence(n);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide a positive integer as the only argument.");
            System.exit(1);
        }
    }
}
