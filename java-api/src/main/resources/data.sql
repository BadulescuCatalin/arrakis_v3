INSERT INTO security (bond_id, bond_name, cusip,isin,bond_type,bond_status,bond_maturity_date,bond_currency )
VALUES ('AZ Holdings Inc', ,'XS1988387210','CORP','active','05-08-2021','USD'),
VALUES ('Acme co', ,'123456780','CORP','active','30-07-2021','USD'),
VALUES ('Sovereign Investments', '123456bh0','A12356111','CORP','active','30-09-2021','USD'),
VALUES ('Astra Trading Ltd', '123456780','USN0280EAR64','CORP','active','30-07-2021','USD'),
VALUES ('Muncipal Gov Of Orange County', 'AMZN 3.15 08/22/27 REGS','USU02320AG12','CORP','active','30-08-2021','USD'),
VALUES ('Goldman Sachs', 'BDCHBW8','B00B6460505','GOVN','active','09-08-2021','GBP'),
VALUES ('Goldman Sachs', 'BDCHBW8','B00B6460506','GOVN','active','09-08-2021','GBP'),
VALUES ('UBS', 'BDCHBW8','B00B6460507','GOVN','active','09-08-2021','GBP'),
VALUES ('UBS', 'BDCHBW8','B00B6460508','GOVN','active','09-08-2021','GBP'),
VALUES ('Barclays', 'BDCHBW8','B00B6460509','GOVN','active','09-08-2021','GBP'),
VALUES ('Barclays', 'BDCHBW8','B00B6460510','GOVN','active','09-08-2021','GBP'),
VALUES ('Barclays', 'BDCHBW8','B00B6460511','GOVN','active','09-08-2021','GBP'),
VALUES ('British Telecom', 'BDCHBW8','B00B6460512','GOVN','active','09-08-2021','GBP'),
VALUES ('Pension Holdings', 'BDCHBW8','B00B6460513','GOVN','active','09-08-2021','GBP'),
VALUES ('Pension Holdings', 'BDCHBW8','B00B6460514','GOVN','active','09-08-2021','GBP'),
VALUES ('Pension Holdings', 'BDCHBW8','B00B6460515','GOVN','active','09-08-2021','GBP'),
VALUES ('Zurich Pension fund 4', '87973RAA8','US87973RAA86','SOVN','active','06-08-2021','USD'),
VALUES ('Zurich Pension fund 4', '87973RAA8','IE00B29LNP31','SOVN','active','22-12-2030','USD');

INSERT INTO book (book_id, book_name)
VALUES ('trading_book_1'),
VALUES ('trading_book_2'),
VALUES ('trading_book_3'),
VALUES ('trading_book_4'),
VALUES ('trading_book_6');

INSERT INTO trade (trade_id, trade_type,trade_currency,trade_currency,trade_quantity,trade_settlement_date,trade_status,trade_date,trade_unit_price)
VALUES ('AZ Holdings Inc', ,'XS1988387210','CORP','active','05-08-2021','USD'),




CREATE TABLE [IF NOT EXISTS] trade (
    trade_id INT NOT NULL [PRIMARY KEY],
    trade_type CHAR(50) NOT NULL,
    trade_currency CHAR(50) NOT NULL,
    trade_quantity INT NOT NULL,
    trade_settlement_date DATE,
    trade_status CHAR(50) NOT NULL,
    trade_date DATE,
    trade_unit_price FLOAT NOT NULL,
    FOREIGN KEY (isin) REFERENCES security(isin)
);