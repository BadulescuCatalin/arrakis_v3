

CREATE TABLE [IF NOT EXISTS] security (
    security_id INT NOT NULL ,
    isin VARCHAR(500) NOT NULL,
    bond_name VARCHAR(250) NOT NULL,
    cusip    VARCHAR(500) ,
    bond_type CHAR(50) NOT NULL,
    bond_status CHAR(50) NOT NULL,
    bond_maturity_date DATE,
    bond_currency CHAR(50) NOT NULL,
    issuer_name VARCHAR(250) NOT NULL,
    trade_id INT,
    PRIMARY KEY(security_id,isin),
    FOREIGN KEY (trade_id) REFERENCES trade(trade_id)
);


CREATE TABLE [IF NOT EXISTS] book (
    book_id INT AUTO_INCREMENT NOT NULL [PRIMARY KEY],
    book_name VARCHAR(250) NOT NULL,
    isin VARCHAR(500),
    FOREIGN KEY (isin) REFERENCES security(isin)
);



CREATE TABLE [IF NOT EXISTS] trade (
    trade_id INT AUTO_INCREMENT NOT NULL [PRIMARY KEY],
    trade_type CHAR(50) NOT NULL,
    trade_currency CHAR(50) NOT NULL,
    trade_quantity INT NOT NULL,
    trade_settlement_date DATE,
    trade_status CHAR(50) NOT NULL,
    trade_date DATE,
    trade_unit_price FLOAT NOT NULL,
    isin VARCHAR(500),
    FOREIGN KEY (isin) REFERENCES security(isin)
);

