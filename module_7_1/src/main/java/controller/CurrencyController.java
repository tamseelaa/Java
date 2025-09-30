package controller;

import dao.CurrencyDao;

public class CurrencyController {
    private final CurrencyDao dao;

    public CurrencyController(CurrencyDao dao) {
        this.dao = dao;
    }

    public double convert(String fromCode, String toCode, double amount) throws Exception {
        double fromRate = dao.getRate(fromCode);
        double toRate = dao.getRate(toCode);

        double amountInEuro = amount * fromRate;
        return amountInEuro / toRate;
    }
}
