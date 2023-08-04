INSERT INTO users (username, email, password) VALUES ('catalin09', 'catalin@gmail.com', 'ZFCbdF+KDZev6wEiO9Bn1Q=='); --abcd
INSERT INTO users (username, email, password) VALUES ('yinghao1', 'yinghao@gmail.com', 'Al40rlYk2DHsmON1/YVVXA=='); --abcd
INSERT INTO users (username, email, password) VALUES ('vladp70','vlad@gmail.com', 'HKOco3ZnqQ2xfpQZWMFIWw=='); --1234
INSERT INTO users (username, email, password) VALUES ('amrutha1','amrutha@gmail.com', 'S/hYUcMuwakxIvIADFHnLQ=='); --1234

INSERT INTO books (book_name)
SELECT DISTINCT LOWER(book_name) FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO counter_party (name)
SELECT DISTINCT bond_holder
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO security (isin,cusip,issuer_name,maturity_date,coupon,type,face_value,currency,status)
SELECT DISTINCT isin, cusip, issuer_name, maturity_date, coupon_percent, type, face_value, bond_currency, status
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO trades (cusip_isin,book_name,counter_party_name,currency,status,quantity,unit_price,buy_sell,trade_date,settlement_date)
SELECT concat(cusip, isin),book_name,bond_holder,trade_currency,trade_status,quantity,unit_price,trade_type,trade_date,settlement_date
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

UPDATE trades t SET t.counter_party_id = (SELECT DISTINCT p.id
    FROM counter_party p
    WHERE p.name = t.counter_party_name);

UPDATE trades t SET t.book_id = (SELECT DISTINCT b.id
    FROM books b
    WHERE LOWER(t.book_name) = LOWER(b.book_name));

UPDATE trades t SET t.security_id = (SELECT DISTINCT s.id
   FROM security s
   WHERE t.cusip_isin = concat(s.cusip, s.isin));

