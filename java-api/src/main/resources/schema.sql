

CREATE TABLE [IF NOT EXISTS] security (
    bond_id INT NOT NULL [PRIMARY KEY],
    bond_name VARCHAR(250) NOT NULL,
    cusip    VARCHAR(500) ,
    isin VARCHAR(500) NOT NULL,
    bond_type VARCHAR(50) NOT NULL,
    bond_status VARCHAR(100) NOT NULL,
    bond_maturity_date DATE,
    bond_currency VARCHAR(50) NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);



CREATE TABLE [IF NOT EXISTS] book (
    book_id INT NOT NULL [PRIMARY KEY],
    book_name VARCHAR(250) NOT NULL,
    FOREIGN KEY (trade_id) REFERENCES trade(trade_id)
);

CREATE TABLE [IF NOT EXISTS] trade (
    trade_id INT NOT NULL [PRIMARY KEY],
    trade_type CHAR(50) NOT NULL,
    trade_currency CHAR(50) NOT NULL,
    trade_quantity INT NOT NULL,
    trade_settlement_date DATE,
    trade_status CHAR(50) NOT NULL,
    trade_date DATE,
    trade_unit_price FLOAT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);

