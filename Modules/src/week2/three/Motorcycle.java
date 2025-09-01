package week2.three;

public class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        this.fuel = "Petrol";
        this.color = "White";
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Motorcycle\nFuel: " + fuel + "\nColor: " + color;
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.0;
    }
}