package module_6_2;

public class CurrencyController {

    public CurrencyController() {
        Currency.addCurrency(new Currency("USD", "US Dollar", 0.85));
        Currency.addCurrency(new Currency("EUR", "Euro", 1.0));
        Currency.addCurrency(new Currency("GBP", "Pound Sterling", 1.15));
        Currency.addCurrency(new Currency("PKR", "Pakistani Rupee", 0.0030));
    }

    public double convert(String fromCode, String toCode, double amount) {
        Currency from = Currency.getCurrency(fromCode);
        Currency to = Currency.getCurrency(toCode);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid currency.");
        }

        double amountInEuro = amount * from.getToEuro();
        return amountInEuro / to.getToEuro();
    }
}
