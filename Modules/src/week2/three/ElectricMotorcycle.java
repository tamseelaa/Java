package week2.three;

public class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle() {
        this.fuel = "Electric";
        this.color = "Green";
    }

    @Override
    public void start() {
        System.out.println("Electric Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Electric Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Electric Motorcycle\nFuel: " + fuel + "\nColor: " + color;
    }

    @Override
    public double calculateFuelEfficiency() {
        return 100.0; // miles per kWh
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Motorcycle...");
    }
}