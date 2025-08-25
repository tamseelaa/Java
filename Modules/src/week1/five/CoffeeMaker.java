package week1.five;

public class CoffeeMaker {
    private boolean isOn;
    private String coffeeType;
    private int coffeeAmount;

    private static final int minAmount = 10;
    private static final int maxAmount = 80;

    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = "normal";
        this.coffeeAmount = 10;
    }

    // turn on/off
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
//
    public boolean isOn() {
        return isOn;
    }

    public void setCoffeeType(String type) {
        if (isOn) {
            if (type.equalsIgnoreCase("normal") || type.equalsIgnoreCase("espresso")) {
                coffeeType = type.toLowerCase();
            }
        }
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeAmount(int amount) {
        if (isOn) {
            if (amount >= minAmount && amount <= maxAmount) {
                coffeeAmount = amount;
            }
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}
