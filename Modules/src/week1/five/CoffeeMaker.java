package week1.five;

public class CoffeeMaker {
    private boolean isOn;
    private String coffeeType;
    private int coffeeAmount;

    private static final int MIN_AMOUNT = 10;
    private static final int MAX_AMOUNT = 80;

    public CoffeeMaker() {
        this.isOn = false;
        this.coffeeType = "normal"; // default
        this.coffeeAmount = 10;     // default
    }

    // turn on/off
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    // set coffee type
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

    // set coffee amount
    public void setCoffeeAmount(int amount) {
        if (isOn) {
            if (amount >= MIN_AMOUNT && amount <= MAX_AMOUNT) {
                coffeeAmount = amount;
            }
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}
