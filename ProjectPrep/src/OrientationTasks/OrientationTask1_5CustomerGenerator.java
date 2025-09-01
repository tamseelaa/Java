package OrientationTasks;
//
public class OrientationTask1_5CustomerGenerator {
    private final Orientation1_5ServicePoint orientation15ServicePoint;

    public OrientationTask1_5CustomerGenerator(Orientation1_5ServicePoint orientation15ServicePoint) {
        this.orientation15ServicePoint = orientation15ServicePoint;
    }

    public void generate(int count) {
        for (int i = 0; i < count; i++) {
            OrientationTask1_3Customer c = new OrientationTask1_3Customer();
            orientation15ServicePoint.addToQueue(c);
        }
    }
}