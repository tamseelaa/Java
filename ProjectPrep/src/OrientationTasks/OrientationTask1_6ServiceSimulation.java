package OrientationTasks;

public class OrientationTask1_6ServiceSimulation {
    public static void main(String[] args) {
        Orientation1_5ServicePoint sp = new Orientation1_5ServicePoint("MainSP");
        OrientationTask1_5CustomerGenerator generator = new OrientationTask1_5CustomerGenerator(sp);

        // Create 5 customers at start
        generator.generate(5);

        // Serve all customers
        sp.serve();
    }
}