package week2.two.Task1and2;

public class SportsCarDriver {
    public static void main(String[] args) {
        System.out.println("----------Normal Car------------");
        Car car = new Car(10, 0);
        for (int i = 0; i < 3; i++) {
            car.accelerate();
            System.out.println("Normal Car speed: " + car.getSpeed() + " km/h | Fuel: " + car.getGasolineLevel());
        }

        System.out.println("----------Sports Car------------");
        SportsCar sportsCar = new SportsCar(10, 0);
        for (int i = 0; i < 3; i++) {
            sportsCar.accelerate();
            System.out.println("Sports Car speed: " + sportsCar.getSpeed() + " km/h | Fuel: " + sportsCar.getGasolineLevel());
        }
    }
}