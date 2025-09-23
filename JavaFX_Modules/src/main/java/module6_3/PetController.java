package module6_3;

class PetController {
    private final Pet pet;
    private boolean shouldMove = false;
    private double targetX, targetY;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void setTarget(double x, double y) {
        targetX = x;
        targetY = y;
        shouldMove = true;
    }

    public void stopMoving() {
        shouldMove = false;
    }

    public void update() {
        if (shouldMove) {
            pet.moveTowards(targetX, targetY);
            // Stop if reached target
            if (pet.getX() == targetX && pet.getY() == targetY) {
                shouldMove = false;
            }
        }
    }

    public Pet getPet() {
        return pet;
    }
}
