package edu.byui.apj.week7;

public class Reverse {
    public static void main(String[] args) {
        String normal = "Hello World";
        String reversed = String.valueOf(new StringBuilder(normal).reverse());
        System.out.println(reversed);
    }

}
