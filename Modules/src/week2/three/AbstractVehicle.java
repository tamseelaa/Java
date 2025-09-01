package week2.three;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String fuel;
    protected String color;

    @Override
    public void charge() {
        System.out.println("No possible to charge.");
    }

    public abstract void start();
    public abstract void stop();
    public abstract String getInfo();
    public abstract double calculateFuelEfficiency();
}