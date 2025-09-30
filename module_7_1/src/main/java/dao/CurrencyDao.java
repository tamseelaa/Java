package dao;

import datasource.MariaDbConnection;
import entity.Currency;

import java.sql.*;
import java.util.*;

public class CurrencyDao {

    public Map<String, Currency> getAllCurrencies() {
        Map<String, Currency> currencies = new HashMap<>();

        String sql = "SELECT abbreviation, name, to_euro FROM Currency";
        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String abbr = rs.getString("abbreviation");
                String name = rs.getString("name");
                double toEuro = rs.getDouble("to_euro");
                currencies.put(abbr, new Currency(abbr, name, toEuro));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencies;
    }

    public double getRate(String abbreviation) throws SQLException {
        String sql = "SELECT to_euro FROM Currency WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, abbreviation);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("to_euro");
                } else {
                    throw new SQLException("Currency not found: " + abbreviation);
                }
            }
        }
    }
}
