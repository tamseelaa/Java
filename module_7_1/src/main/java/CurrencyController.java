import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CurrencyController {

    // Database connection info
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/currency_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Shahid75";

    public CurrencyController() {
        loadCurrenciesFromDatabase();
    }

    private void loadCurrenciesFromDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT* FROM Currency";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String abbreviation = rs.getString("abbreviation");
                String name = rs.getString("name");
                double toEuro = rs.getDouble("to_euro");

                Currency.addCurrency(new Currency(abbreviation, name, toEuro));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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