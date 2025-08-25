package week1.five;


public class Television {

    private boolean start;
    private int channel;

    public Television() {
        this.start = false;
        this.channel = 1;
    }

    // Turn TV start & stop
    public void pressOnOff() {
        this.start = !this.start;
    }
    public boolean isOn() {
        return this.start;
    }
    // Get current channel
    public int getChannel() {
        return this.channel;
    }
    public void setChannel(int channel) {
        if (channel > 10) {
            this.channel = 1; // wrap back to 1 after 10
        } else if (channel < 1) {
            this.channel = 10; // optional: wrap backwards
        } else {
            this.channel = channel;
        }
    }
}