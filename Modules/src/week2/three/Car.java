package week2.three;

public class Car extends AbstractVehicle {
    public Car() {
        this.fuel = "Petrol";
        this.color = "Red";
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Car\nFuel: " + fuel + "\nColor: " + color;
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.0;
    }
}