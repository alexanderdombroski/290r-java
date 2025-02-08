package edu.byui.apj.adventure;

import java.util.regex.Pattern;

public class TerminalUtils {
    private TerminalUtils() {}

    public static void sleep(long milliseconds) {
        System.out.flush();
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ignored) { }
    }

    public static String center(String phrase, int minLength) {
        int length = Ansi.getLengthWithoutAnsi(phrase);
        int totalPadding = minLength - length;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        if (length > minLength) {
            leftPadding = 0;
            rightPadding = 0;
        }
        return " ".repeat(leftPadding) + phrase + " ".repeat(rightPadding);
    }

    public static final class Ansi {
        public static String colorRed(String phrase) { return "\u001B[31m" + phrase + "\u001B[0m"; }
        public static String colorBlue(String phrase) { return "\u001B[34m" + phrase + "\u001B[0m"; }
        public static String colorGreen(String phrase) { return "\u001B[32m" + phrase + "\u001B[0m"; }
        public static String colorYellow(String phrase) { return "\u001B[33m" + phrase + "\u001B[0m"; }
        public static String colorMagenta(String phrase) { return "\u001B[35m" + phrase + "\u001B[0m"; }
        public static String colorCyan(String phrase) { return "\u001B[36m" + phrase + "\u001B[0m"; }

        public static int getLengthWithoutAnsi(String ansiString) {
            return ansiString.replaceAll("\u001B\\[[0-9;]*m", "").length();
        }
    }

    /**
     * Prompts the user for integer input within a specified range, repeatedly until a valid input is provided.
     */
    public static int getValidInt(String prompt, int min, int max) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        do {
            System.out.print(prompt);
            String str = scanner.nextLine();
            if (!pattern.matcher(str).matches()) {
                System.out.println(Ansi.colorRed("Please type a valid number"));
                continue;
            }
            int num = Integer.parseInt(str);
            if (num < min || num > max) {
                System.out.println(Ansi.colorRed(String.format("Type a number within the range %d and %d%n", min, max)));
                continue;
            }
            return num;
        } while (true);
    }
}
