package bdd.examples.d02;

public class Calculator {
    String stored="";

    public String getDisplay() {
        return stored;
    }

    public void press(String key) {
        if (stored.isEmpty() && key.equals("0"))
            return;
        stored += key;
    }
}
