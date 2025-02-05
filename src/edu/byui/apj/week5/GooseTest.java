package edu.byui.apj.week5;

public class GooseTest {

    private static GooseTest instance;

    private GooseTest() {}

    public synchronized static GooseTest getInstance() {
        if (instance == null) {
            instance = new GooseTest();
        }
        return instance;
    }

    public void runGooseTest() {
        Goose goose = new Goose();
        System.out.println(goose);
        System.out.println(new Goose("Gertrude"));
        System.out.println(new Goose("Fanny", true));
        System.out.println(new Goose("Bob", "Male", false));
        goose.doGooseStuff();
    }

    public static void main(String[] args) {
        GooseTest.getInstance().runGooseTest();
    }
}
