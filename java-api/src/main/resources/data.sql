--
--INSERT INTO users (name, email, password) VALUES ('Badulescu Catalin', 'catalin@gmail.com', 'abcd');
--INSERT INTO users (name, email, password) VALUES ('Petrovici Vlad', 'vlad@gmail.com', '1234');

INSERT INTO books (book_name)
SELECT DISTINCT LOWER(book_name) FROM CSVREAD('.\\src\\main\\resources\\db-bonds-data.csv');

--
--
--INSERT INTO users (name,email,password,role)
--SELECT name,email,password,role FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');
--
--
INSERT INTO counter_party (name)
SELECT DISTINCT bond_holder
FROM CSVREAD('.\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO users (username, email, password) VALUES ('catalin09', 'catalin@gmail.com', 'ZFCbdF+KDZev6wEiO9Bn1Q=='); --abcd
INSERT INTO users (username, email, password) VALUES ('yinghao1', 'yinghao@gmail.com', 'Al40rlYk2DHsmON1/YVVXA=='); --abcd
INSERT INTO users (username, email, password) VALUES ('vladp70','vlad@gmail.com', 'HKOco3ZnqQ2xfpQZWMFIWw=='); --1234
INSERT INTO users (username, email, password) VALUES ('amrutha1','amrutha@gmail.com', 'S/hYUcMuwakxIvIADFHnLQ=='); --1234

INSERT INTO book_user (book_id, user_id)
VALUES (1, 1);
INSERT INTO book_user (book_id, user_id)
VALUES (1, 2);
INSERT INTO book_user (book_id, user_id)
VALUES (2, 1);
INSERT INTO book_user (book_id, user_id)
VALUES (2, 3);
INSERT INTO book_user (book_id, user_id)
VALUES (3, 1);
INSERT INTO book_user (book_id, user_id)
VALUES (3, 4);
INSERT INTO book_user (book_id, user_id)
VALUES (4, 2);
INSERT INTO book_user (book_id, user_id)
VALUES (4, 3);
INSERT INTO book_user (book_id, user_id)
VALUES (5, 4);
INSERT INTO book_user (book_id, user_id)
VALUES (5, 2);


--INSERT INTO security (isin,cusip,issuer_name,maturity_date,coupon,type,face_value,currency,status)
--SELECT isin, cusip, issuer_name, PARSEDATETIME(maturity_date, 'd/M/yyyy'), coupon_percent, type, face_value, bond_currency, status
--FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO security (isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status)
SELECT DISTINCT isin, cusip, issuer_name, PARSEDATETIME(bond_maturity_date, 'd/M/yyyy'), coupon_percent, type, face_value, bond_currency, status
FROM CSVREAD('.\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO trades(book_id, counter_party_id, security_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date)
SELECT book_id, counterparty_id, security_id, trade_currency, trade_status, quantity, unit_price, trade_type, PARSEDATETIME(trade_date,'d/M/yyyy') , PARSEDATETIME(trade_settlement_date, 'd/M/yyyy')
FROM CSVREAD('.\\src\\main\\resources\\trades.csv');

INSERT INTO bond (id, ISIN, CUSIP, ISSUER_NAME, BOND_MATURITY_DATE, COUPON, BOND_TYPE, FACE_VALUE, BOND_CURRENCY, BOND_STATUS, TRADE_CURRENCY, TRADE_STATUS, QUANTITY, UNIT_PRICE, BUY_SELL, TRADE_DATE, SETTLEMENT_DATE, BOOK_NAME, BOND_HOLDER)
SELECT ROW_NUMBER() OVER (ORDER BY isin), ISIN, CUSIP, ISSUER_NAME, BOND_MATURITY_DATE, COUPON, BOND_TYPE, FACE_VALUE, BOND_CURRENCY, BOND_STATUS, TRADE_CURRENCY, TRADE_STATUS, QUANTITY, UNIT_PRICE, BUY_SELL, TRADE_DATE, SETTLEMENT_DATE, BOOK_NAME, BOND_HOLDER
FROM all_bonds;






