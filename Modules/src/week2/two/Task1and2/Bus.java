package week2.two.Task1and2;

public class Bus extends Car {
    private int passengers;
    private int capacity;

    public Bus(double gasolineLevel, double speed, int capacity) {
        super(gasolineLevel, speed);
        this.capacity = capacity;
        this.passengers = 0;
    }

    public void passengerEnter() {
        if (passengers < capacity) {
            passengers++;
            System.out.println("One passenger entered. Current passengers: " + passengers);
        } else {
            System.out.println("Bus is full! Cannot take more passengers.");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            passengers--;
            System.out.println("One passenger exited. Current passengers: " + passengers);
        } else {
            System.out.println("No passengers to exit.");
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public int getCapacity() {
        return capacity;
    }
}