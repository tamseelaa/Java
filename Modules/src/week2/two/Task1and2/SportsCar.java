package week2.two.Task1and2;
public class SportsCar extends Car {

    public SportsCar(double gasolineLevel, double speed) {
        super(gasolineLevel, speed);
    }

    public SportsCar(String typeName) {
        super(typeName);
    }

    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            setSpeed(getSpeed() + 20);
            setGasolineLevel(getGasolineLevel() - 2);
        } else {
            setSpeed(0);
        }
    }

    @Override
    void decelerate(int amount) {
        if (getGasolineLevel() > 0) {
            if (amount > 0) {
                setSpeed(Math.max(0, getSpeed() - (amount * 2))); // stronger braking
            }
        } else {
            setSpeed(0);
        }
    }
}