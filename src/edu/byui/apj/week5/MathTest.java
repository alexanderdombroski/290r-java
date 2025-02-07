package edu.byui.apj.week5;

public class MathTest {
    public static void main(String[] args) {
        System.out.println(MathUtils.PI * MathUtils.square(15));
        System.out.println(MathUtils.square(5));
        System.out.println(MathUtils.reverseNumber(12345));
        System.out.println(MathUtils.isValidInt("12345"));
        System.out.println(MathUtils.isValidInt("123.45"));
        System.out.println(MathUtils.toHex(32767));
        System.out.println(MathUtils.formatAsDate(20200220));
        System.out.println(MathUtils.formatAsDate(2021212));
        System.out.println(MathUtils.getInstanceCount());
    }
}
