package W1;

public class ServiceSimulation {
    public static void main(String[] args) {
        ServicePoint sp = new ServicePoint("MainSP");
        CustomerGenerator generator = new CustomerGenerator(sp);

        // Create 5 customers at start
        generator.generate(5);

        // Serve all customers
        sp.serve();
    }
}