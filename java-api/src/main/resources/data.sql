INSERT INTO security (security_id, isin, bond_name, cusip,bond_type,bond_status,bond_maturity_date,bond_currency,issuer_name,trade_id )
VALUES (1,'XS1988387210','AZ Holdings Inc', ,'CORP','active','05-08-2021','USD','BNPParibasIssu 4,37% Microsoft Corp (USD)',{1,2}),
VALUES (2,'USN0280EAR64','Acme co', '123456780','CORP','active','30-07-2021','USD','Airbus 3.15%  USD',{3,4}),

VALUES (2,'USN0280EAR64','Astra Trading Ltd','123456780','CORP','active','30-07-2021','USD','Airbus 3.15%  USD',6),
VALUES (3,'A12356111','Sovereign Investments', '123456bh0','CORP','active','30-09-2021','USD','UBS Facebook (USD)',5),
VALUES (3,'A12356111','Sovereign Investments', '123456bh0','CORP','active','30-09-2021','USD','UBS Facebook (USD)',7),
VALUES (4,'USU02320AG12','Muncipal Gov Of Orange County', 'AMZN 3.15 08/22/27 REGS','CORP','active','30-08-2021','USD','Amazon',8),
VALUES (4,'USU02320AG12','Muncipal Gov Of Orange County', 'AMZN 3.15 08/22/27 REGS','CORP','active','30-08-2021','USD','Amazon',9),
VALUES (5,'B00B6460505','Goldman Sachs', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',10),
VALUES (6,'B00B6460506','Goldman Sachs', 'BDCHBW8',,'GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',11),
VALUES (7,'B00B6460507','UBS', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',12),
VALUES (8,'B00B6460508','UBS', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',13),
VALUES (9,'B00B6460509','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',14),
VALUES (10,'B00B6460510','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',15),
VALUES (11,'B00B6460511','Barclays', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',16),
VALUES (12,'B00B6460512','British Telecom', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',17),
VALUES (13,'B00B6460513','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',18),
VALUES (14,'B00B6460514','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',19),
VALUES (15,'B00B6460515','Pension Holdings', 'BDCHBW8','GOVN','active','09-08-2021','GBP','HM Treasury United Kingdon',20),
VALUES (16,'Zurich Pension fund 4', '87973RAA8','US87973RAA86','SOVN','active','06-08-2021','USD'),
VALUES ('Zurich Pension fund 4', '87973RAA8','IE00B29LNP31','SOVN','active','22-12-2030','USD');

INSERT INTO book (book_id, book_name, isin)
VALUES (,'trading_book_1','XS1988387210'),
VALUES (,'trading_book_2','USN0280EAR64'),
VALUES (,'trading_book_2','A12356111'),
VALUES (,'trading_book_3','A12356111'),
VALUES (,'trading_book_4','USU02320AG12'),
VALUES (,'trading_book_4','US87973RAA86'),
VALUES (,'trading_book_6','GB00B6460505'),
VALUES (,'trading_book_6','GB00B6460506'),
VALUES (,'trading_book_6','GB00B6460507'),
VALUES (,'trading_book_6','GB00B6460508'),
VALUES (,'trading_book_6','GB00B6460509'),
VALUES (,'trading_book_6','GB00B6460510'),
VALUES (,'trading_book_6','GB00B6460511'),
VALUES (,'trading_book_6','GB00B6460512'),
VALUES (,'trading_book_6','GB00B6460513'),
VALUES (,'trading_book_6','GB00B6460514'),
VALUES (,'trading_book_6','GB00B6460515');


INSERT INTO trade (trade_id, trade_type,trade_currency,trade_currency,trade_quantity,trade_settlement_date,trade_status,trade_date,trade_unit_price)
VALUES ('AZ Holdings Inc', ,'XS1988387210','CORP','active','05-08-2021','USD'),




