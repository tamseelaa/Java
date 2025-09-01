package W1;

public class CustomerGenerator {
    private final ServicePoint servicePoint;

    public CustomerGenerator(ServicePoint servicePoint) {
        this.servicePoint = servicePoint;
    }

    public void generate(int count) {
        for (int i = 0; i < count; i++) {
            Customer c = new Customer();
            servicePoint.addToQueue(c);
        }
    }
}