DROP DATABASE IF EXISTS currency_db;

-- 2. Create a new database
CREATE DATABASE currency_db;

-- Use the database
USE currency_db;

-- 3. Create a table for storing currencies
DROP TABLE IF EXISTS Currency;

CREATE TABLE Currency (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          abbreviation VARCHAR(3) NOT NULL UNIQUE,
                          name VARCHAR(50) NOT NULL,
                          to_euro DECIMAL(10,6) NOT NULL
);

-- 4. Insert at least 8 currencies
INSERT INTO Currency (abbreviation, name, to_euro) VALUES
                                                       ('EUR', 'Euro', 1.000000),
                                                       ('USD', 'US Dollar', 0.850000),
                                                       ('GBP', 'British Pound', 1.150000),
                                                       ('PKR', 'Pakistani Rupee', 0.003000),
                                                       ('JPY', 'Japanese Yen', 0.006300),
                                                       ('AUD', 'Australian Dollar', 0.620000),
                                                       ('CAD', 'Canadian Dollar', 0.640000),
                                                       ('INR', 'Indian Rupee', 0.0097);

-- 5. Drop user if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- 6. Create user
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'app123';

-- 7. Grant privileges (only what the app needs: SELECT for reading, INSERT for adding new currencies)
GRANT SELECT, INSERT ON currency_db.Currency TO 'appuser'@'localhost';

-- Apply changes
FLUSH PRIVILEGES;