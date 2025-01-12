package bdd.examples.d04;

public class Calculator {
    String stored="0";

    public String getDisplay() {
        return stored;
    }

    public void press(String key) {
        if (key.isEmpty())
            return;
        if (stored.equals("0")) {
            if (key.equals("0")) {
                return;
            }
            stored = "";
        }
        stored += key;

    }
}
