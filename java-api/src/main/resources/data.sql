INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);

--INSERT INTO bonds (id, bond_maturity_date, isin) VALUES (1, '01/08/2023', '1234ABCD');
--INSERT INTO bonds (id, bond_maturity_date, isin) VALUES (2, '05/08/2023', '1234ABCE');
--INSERT INTO bonds (id, bond_maturity_date, isin) VALUES (3, '10/08/2023', '1234ABCF');

--INSERT INTO bonds (id, bond_maturity_date, isin) VALUES (3, '10/08/2023', '1234ABCF');

INSERT INTO users (username, email, password) VALUES ('catalin09', 'catalin@gmail.com', 'ZFCbdF+KDZev6wEiO9Bn1Q=='); --abcd
INSERT INTO users (username, email, password) VALUES ('yinghao1', 'yinghao@gmail.com', 'Al40rlYk2DHsmON1/YVVXA=='); --abcd
INSERT INTO users (username, email, password) VALUES ('vladp70','vlad@gmail.com', 'HKOco3ZnqQ2xfpQZWMFIWw=='); --1234
INSERT INTO users (username, email, password) VALUES ('amrutha1','amrutha@gmail.com', 'S/hYUcMuwakxIvIADFHnLQ=='); --1234

INSERT INTO books (book_name)
SELECT DISTINCT LOWER(book_name) FROM CSVREAD('.\\src\\main\\resources\\db-bonds-data.csv');



INSERT INTO security ( isin, cusip, type, status, maturity_date,currency, issuer_name, coupon, face_value)
VALUES ('XS1988387210','AZ Holdings Inc','CORP','active','05-08-2021','USD', 'ASSA',10.2, 202.8);
--VALUES (2,'USN0280EAR64','Acme co', '123456780','CORP','active','30-07-2021','USD','Airbus 3.15%  USD',{3,4}),
--
--VALUES (2,'USN0280EAR64','Astra Trading Ltd','123456780','CORP','active','30-07-2021','USD','Airbus 3.15%  USD',6),
--VALUES (3,'A12356111','Sovereign Investments', '123456bh0','CORP','active','30-09-2021','USD','UBS Facebook (USD)',5),
--VALUES (3,'A12356111','Sovereign Investments', '123456bh0','CORP','active','30-09-2021','USD','UBS Facebook (USD)',7),
--VALUES (4,'USU02320AG12','Muncipal Gov Of Orange County', 'AMZN 3.15 08/22/27 REGS','CORP','active','30-08-2021','USD','Amazon',8),
--VALUES (4,'USU02320AG12','Muncipal Gov Of Orange County', 'AMZN 3.15 08/22/27 REGS','CORP','active','30-08-2021','USD','Amazon',9),
--VALUES (5,'B00B6460505','Goldman Sachs', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',10),
--VALUES (6,'B00B6460506','Goldman Sachs', 'BDCHBW8',,'GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',11),
--VALUES (7,'B00B6460507','UBS', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',12),
--VALUES (8,'B00B6460508','UBS', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',13),
--VALUES (9,'B00B6460509','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',14),
--VALUES (10,'B00B6460510','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',15),
--VALUES (11,'B00B6460511','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',16),
--VALUES (12,'B00B6460512','British Telecom', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',17),
--VALUES (13,'B00B6460513','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',18),
--VALUES (14,'B00B6460514','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',19),
--VALUES (15,'B00B6460515','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',20),
--VALUES (16,'Zurich Pension fund 4', '87973RAA8','US87973RAA86','SOVN','active','06-08-2021','USD'),
--VALUES ('Zurich Pension fund 4', '87973RAA8','IE00B29LNP31','SOVN','active','22-12-2030','USD');
--
--INSERT INTO books (book_name) VALUES ('trading_book_1');
--INSERT INTO books (book_name) VALUES ('trading_book_2');
--INSERT INTO books (book_name) VALUES ('trading_book_2');
--INSERT INTO books (book_name) VALUES ('trading_book_3');
--INSERT INTO books (book_name) VALUES ('trading_book_4');
--INSERT INTO books (book_name) VALUES ('trading_book_6');
--
INSERT INTO counter_party(name) VALUES ('AZ Holdings Inc');
--INSERT INTO Counterparty(name) VALUES ('Acme co');
--INSERT INTO Counterparty(name) VALUES ('Sovereign Investments');
--INSERT INTO Counterparty(name) VALUES ('Astra Trading Ltd');
--INSERT INTO Counterparty(name) VALUES ('Muncipal Gov Of Orange County');
--INSERT INTO Counterparty(name) VALUES ('Goldman Sachs');
--INSERT INTO Counterparty(name) VALUES ('UBS');
--INSERT INTO Counterparty(name) VALUES ('Barclays');
--INSERT INTO Counterparty(name) VALUES ('British Telecom');
--INSERT INTO Counterparty(name) VALUES ('Pension Holdings');
--INSERT INTO Counterparty(name) VALUES ('Zurich Pension fund 4');

INSERT INTO trades (book_id, security_id, counter_party_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date)
VALUES (1, 1, 1, 'USD', 'active', 10, 12.10, 'buy', '10/10/2023', '11/10/2023');
