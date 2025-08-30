package week2.two.Task1and2;

public class BusDriver {
    public static void main(String[] args) {
        Bus cityBus = new Bus(50, 0, 5);

        System.out.println("Bus created with capacity of " + cityBus.getCapacity() + " passengers.");
        cityBus.passengerEnter();
        cityBus.passengerEnter();
        cityBus.passengerEnter();

        cityBus.accelerate();
        System.out.println("Bus speed after accelerating: " + cityBus.getSpeed() + " km/h");

        cityBus.passengerExit();
        cityBus.passengerExit();
        System.out.println("Final passenger count: " + cityBus.getPassengers());
    }
}