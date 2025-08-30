package week2.two.Task1and2;

/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;
    private boolean cruiseOn;
    private double cruiseTarget;
    private static final double min_cruise_speed=10;
    private static final double max_cruise_speed=200;


    public Car(double gasolineLevel, double speed){// ask teacher if its tank/gasoline capacity or gasoline level
        this.gasolineLevel = gasolineLevel;
        this.speed = speed;
        this.tankCapacity=100;
    }
    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
        this.tankCapacity=100;
        // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0){
            speed += 10;
            gasolineLevel -= 1;}
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    //getter
    protected void setSpeed(double speed) { this.speed = speed; }
    protected void setGasolineLevel(double gasolineLevel) { this.gasolineLevel = gasolineLevel; }

    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = tankCapacity;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
    public void setCruiseTarget(double target) {
        this.cruiseTarget = target;
    }

    public double getCruiseTarget() {
        return cruiseTarget;
    }

    public boolean turnOnCruiseControl() {
        if (gasolineLevel <= 0) {
            System.out.println("Cruise control cannot be activated. Tank is empty!");
            return false;
        }

        if (cruiseTarget < min_cruise_speed || cruiseTarget > max_cruise_speed) {
            System.out.println("Cruise target must be between " +
                    min_cruise_speed + " and " + max_cruise_speed + " km/h.");
            return false;
        }

        //Try to reach the target speed
        while (speed < cruiseTarget && gasolineLevel > 0) {
            accelerate();
            System.out.println("Accelerating...       Current speed: " + speed + " km/h");
        }

        while (speed > cruiseTarget && gasolineLevel > 0) {
            decelerate(5);
            System.out.println("Decelerating...       Current speed: " + speed + " km/h");
        }

        // If we run out of fuel before reaching the target
        if (gasolineLevel <= 0 && speed != cruiseTarget) {
            System.out.println("Cruise control failed: could not reach target speed due to low fuel.");
            cruiseOn = false;
            return false;
        }

        // If speed matches the target, cruise control is on
        if (speed == cruiseTarget) {
            cruiseOn = true;
            return true;
        } else {
            // This means speed overshot or undershot target for some reason
            System.out.println("Cruise control could not stabilize at target speed.");
            cruiseOn = false;
            return false;
        }
    }

    public void turnOffCruiseControl() {
        cruiseOn = false;
    }

    public boolean isCruiseOn() {
        return cruiseOn;
    }
}
