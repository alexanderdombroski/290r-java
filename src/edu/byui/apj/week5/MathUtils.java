package edu.byui.apj.week5;

import java.util.regex.*;

public class MathUtils {
    private static int instanceCount = 0;
    public static final double PI = 3.141592653589793;


    private MathUtils() {}
    static {
        instanceCount++;
    }


    public static int getInstanceCount() {
        return instanceCount;
    }


    public static int square(int number) {
        return number * number;
    }

    public static String toHex(int number) {
        return Integer.toHexString(number);
    }

    public static String reverseNumber(int number) {
        return new StringBuilder(String.valueOf(number)).reverse().toString();
    }

    public static boolean isValidInt(String input) {
        Pattern pattern = Pattern.compile("-?\\d+");
        return pattern.matcher(input).matches();
    }


    public static String formatAsDate(long number) {
        String numStr = String.valueOf(number);

        // Ensure it is exactly 10 digits
        if (!numStr.matches("\\d{8}")) {
            return "Invalid input: Must be a 8-digit number.";
        }

        // Extract YYYY, MM, DD
        StringBuilder formattedDate = new StringBuilder();
        formattedDate.append(numStr.substring(0, 4)).append("-")
                .append(numStr.substring(4, 6)).append("-")
                .append(numStr.substring(6, 8));

        return formattedDate.toString();
    }

}
