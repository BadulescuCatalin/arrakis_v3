--
--INSERT INTO users (name, email, password) VALUES ('Badulescu Catalin', 'catalin@gmail.com', 'abcd');
--INSERT INTO users (name, email, password) VALUES ('Petrovici Vlad', 'vlad@gmail.com', '1234');

INSERT INTO books (id,book_name)
SELECT DISTINCT book_id,LOWER(book_name) FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

--
--
--INSERT INTO users (name,email,password,role)
--SELECT name,email,password,role FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');
--
----INSERT INTO book_user ()
----SELECT  FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');
--

--
INSERT INTO counter_party (name)
SELECT DISTINCT bond_holder
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO users (username, email, password) VALUES ('catalin09', 'catalin@gmail.com', 'ZFCbdF+KDZev6wEiO9Bn1Q=='); --abcd
INSERT INTO users (username, email, password) VALUES ('yinghao1', 'yinghao@gmail.com', 'Al40rlYk2DHsmON1/YVVXA=='); --abcd
INSERT INTO users (username, email, password) VALUES ('vladp70','vlad@gmail.com', 'HKOco3ZnqQ2xfpQZWMFIWw=='); --1234
INSERT INTO users (username, email, password) VALUES ('amrutha1','amrutha@gmail.com', 'S/hYUcMuwakxIvIADFHnLQ=='); --1234

INSERT INTO security (isin,cusip,issuer_name,maturity_date,coupon,type,face_value,currency,status)
SELECT isin, cusip, issuer_name, maturity_date, coupon_percent, type, face_value, bond_currency, status
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');

INSERT INTO trades (id,book_id,security_id,counter_party_id,currency,status,quantity,unit_price,buy_sell,trade_date,settlement_date)
SELECT trade_id,book_id,security_id,counter_party_id,trade_currency,trade_status,quantity,unit_price,trade_type,trade_date,settlement_date
FROM CSVREAD('.\\java-api\\src\\main\\resources\\db-bonds-data.csv');


