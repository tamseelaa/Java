package week1.five;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        // === Control Tests ===
        System.out.println("\n\n\n--- Testing Cruise Control ---");

        // 1: Valid target (reachable)
        myCar.setCruiseTarget(120);   // bigger than current 60
        boolean cruiseActivated = myCar.turnOnCruiseControl();
        if (cruiseActivated) {
            System.out.println("Cruise control activated at " + myCar.getCruiseTarget() + " km/h");
        } else {
            System.out.println("Failed to activate cruise control.");
        }

        // 2: Unreachable target due to low fuel
        Car lowFuelCar = new Car("Nissan Micra");
        lowFuelCar.fillTank();
        lowFuelCar.accelerate();   // burn a little fuel
        lowFuelCar.accelerate();
        lowFuelCar.accelerate();
        lowFuelCar.accelerate();

        lowFuelCar.setCruiseTarget(200);
        if (!lowFuelCar.turnOnCruiseControl()) {
            System.out.println("Cruise control failed: could not reach " + lowFuelCar.getCruiseTarget() + " km/h.");
        }
    }
}