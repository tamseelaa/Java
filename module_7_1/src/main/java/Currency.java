import java.util.HashMap;
import java.util.Map;

public class Currency {
    private final String Sign;
    private final String name;
    private final double toEuro; // conversion rate from euro

    // static storage for all currencies
    private static final Map<String, Currency> currencies = new HashMap<>();

    public Currency(String Sign, String name, double toEuro) {
        this.Sign = Sign;
        this.name = name;
        this.toEuro = toEuro;
    }

    public String getSign() { return Sign; }
    public String getName() { return name; }
    public double getToEuro() { return toEuro; }

    @Override
    public String toString() {
        return Sign + " - " + name;
    }

    public static void addCurrency(Currency currency) {
        currencies.put(currency.getSign(), currency);
    }

    public static Currency getCurrency(String sign) {
        return currencies.get(sign);
    }

    public static Map<String, Currency> getAllCurrencies() {
        return currencies;
    }
}
