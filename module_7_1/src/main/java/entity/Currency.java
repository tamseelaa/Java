package entity;

public class Currency {
    private final String abbreviation;
    private final String name;
    private final double toEuro; // conversion rate from euro

    public Currency(String abbreviation, String name, double toEuro) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.toEuro = toEuro;
    }

    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getToEuro() { return toEuro; }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
