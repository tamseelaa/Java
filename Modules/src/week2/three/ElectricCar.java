package week2.three;

public class ElectricCar extends AbstractVehicle {
    public ElectricCar() {
        this.fuel = "Electric";
        this.color = "Purple";
    }

    @Override
    public void start() {
        System.out.println("Electric Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Electric Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Electric Car\nFuel: " + fuel + "\nColor: " + color;
    }

    @Override
    public double calculateFuelEfficiency() {
        return 100.0; // miles per kWh
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Car...");
    }
}