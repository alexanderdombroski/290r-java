package edu.byui.apj.adventure;

class TerminalUtils {
    private TerminalUtils() {}

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ignored) { }
    }

    public static String center(String phrase, int minLength) {
        int totalPadding = minLength - phrase.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        if (phrase.length() > minLength) {
            leftPadding = 0;
            rightPadding = 0;
        }
        return " ".repeat(leftPadding) + phrase + " ".repeat(rightPadding);
    }
}
