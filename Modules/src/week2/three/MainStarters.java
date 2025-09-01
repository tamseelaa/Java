package week2.three;

public class MainStarters {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();
        Vehicle bus = new Bus();
        ElectricCar electricCar = new ElectricCar();
        ElectricCar electricBike = new ElectricCar();


        System.out.println("Vehicle Demonstration\n");

        car.start();
        car.stop();
        System.out.println("Car Information:\n" + car.getInfo());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " mpg\n");

        motorcycle.start();
        motorcycle.stop();
        System.out.println("Motorcycle Information:\n" + motorcycle.getInfo());
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " mpg\n");

        bus.start();
        bus.stop();
        System.out.println("Bus Information:\n" + bus.getInfo());
        System.out.println("Fuel Efficiency: " + bus.calculateFuelEfficiency() + " mpg\n");

        electricCar.start();
        electricCar.stop();
        System.out.println("Car Information:\n" + electricCar.getInfo());

        electricBike.start();
        electricBike.stop();
        System.out.println("Bike Information:\n" + electricBike.getInfo());
    }
}