-- 1. Retrieve all currencies
SELECT * FROM Currency;

-- 2. Retrieve currency with abbreviation EUR
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- 3. Retrieve the number of currencies
SELECT COUNT(*) AS currency_count FROM Currency;

-- 4. Retrieve the currency with the highest exchange rate
SELECT *
FROM Currency
ORDER BY to_euro DESC
    LIMIT 1;