import React, { useState, useEffect } from 'react';
import { Accordion } from 'react-bootstrap';
import styles from "../security/AllSecurities.module.css";
import { findBooks, findBookTrades } from '../../services/BookServices'
import BondDetails from './BondDetails';

export const Books = (props) => {

  const [books, setBooks] = useState([]);
  const [trades, setTrades] = useState([]);
  const handleAccordionItemClick = (id) => {
    const map = {
      "email": localStorage.getItem("email"),
      "bookid": id
    }
    findBookTrades(map)
      .then(res => {
        setTrades(res.data);
        console.log(trades);
      })
      .catch(err => {
        setBooks([]);
        console.log(err);
      })
  }

  useEffect(() => {
    getBooksFromAPI();
  },
    []
  )

  const getBooksFromAPI = () => {
    const map = {
      "email": localStorage.getItem("email")
    };
    findBooks(map)
      .then(res => {
        console.log(res.data);
        const bookList = res.data.map(item => {
          const [id, book_name] = item.split(',');
          return [id, book_name];
        });
        console.log(bookList)
        setBooks(bookList);
      })
      .catch(err => {
        setBooks([]);
        console.log(err);
      })
  }


  return (
    <Accordion defaultActiveKey="0" className={styles.accordion}>
      {books.map((book, index) => (
        <Accordion.Item key={index} eventKey={index.toString()} onClick={() => handleAccordionItemClick(book[0])}>
          <Accordion.Header>{book[1]}</Accordion.Header>
          <Accordion.Body>
            {trades.map((trade, tradeIndex) => (
              <BondDetails key={tradeIndex} info={trade} />
            ))}
          </Accordion.Body>
        </Accordion.Item>
      ))}
    </Accordion>
  )
}
