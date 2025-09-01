package week2.three;

public class Bus extends AbstractVehicle {
    public Bus() {
        this.fuel = "Petrol";
        this.color = "Blue";
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Bus\nFuel: " + fuel + "\nColor: " + color;
    }

    @Override
    public double calculateFuelEfficiency() {
        return 25.0;
    }
}
