import React, { useState, useEffect } from "react";
import { findBonds } from "../../services/BondServices";
import { Button, Card, Col, Form, Row, Table } from "react-bootstrap";
import styles from "./Bonds.module.css";
import { useNavigate } from "react-router-dom";

const dummyData = [
  {
    "trade_type": "buy",
    "trade_currency": "USD",
    "quantity": 50,
    "trade_settlement_date": "04/08/2021",
    "trade_status": "open",
    "trade_date": "13/05/2021",
    "unit_price": 90,
    "coupon_percent": 4.37,
    "bond_currency": "USD",
    "cusip": "",
    "face_value (mn)": 1000,
    "isin": "XS1988387210",
    "issuer_name": "BNPParibasIssu 4,37% Microsoft Corp (USD)",
    "bond_maturity_date": "05/08/2023",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_1",
    "bond_holder": "AZ Holdings Inc"
  },
  {
    "trade_type": "sell",
    "trade_currency": "GBP",
    "quantity": 40,
    "trade_settlement_date": "04/08/2021",
    "trade_status": "open",
    "trade_date": "04/02/2021",
    "unit_price": 89.56,
    "coupon_percent": 4.37,
    "bond_currency": "USD",
    "cusip": "",
    "face_value (mn)": 1000,
    "isin": "XS1988387211",
    "issuer_name": "BNPParibasIssu 4,37% Microsoft Corp (USD)",
    "bond_maturity_date": "05/08/2023",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_1",
    "bond_holder": "AZ Holdings Inc"
  },
  {
    "trade_type": "buy",
    "trade_currency": "USD",
    "quantity": 1000,
    "trade_settlement_date": "23/08/2021",
    "trade_status": "open",
    "trade_date": "13/05/2021",
    "unit_price": 105.775,
    "coupon_percent": 3.15,
    "bond_currency": "USD",
    "cusip": "123456780",
    "face_value (mn)": 900,
    "isin": "USN0280EAR64",
    "issuer_name": "Airbus 3.15%  USD",
    "bond_maturity_date": "12/07/2021",
    "status": "active",
    "type": "CORP",
    "book_name": "trading_book_2",
    "bond_holder": "Acme co"
  }
];

export const Bonds = (props) => {
  const [bonds, setBonds] = useState(dummyData);
  const [date, setDate] = useState("");
  const [isin, setIsin] = useState(new Set());
  const [warning, setWarning] = useState("");
  const [isinnone, setIsinnone] = useState("");
  const navigate = useNavigate();

  // get bonds values
  const deBonds = [];

  const dateChange = e => {
    setIsinnone("");
    setDate(e.target.value);
    setIsin(new Set());
    setWarning("");
  }

  const checkClick = e => {
    e.preventDefault();
    let enteredDate = date.split("/");
    let day = +enteredDate[0];
    let month = +enteredDate[1];
    let year = +enteredDate[2];
    let temIsin = new Set();
    if (Number.isInteger(day) && Number.isInteger(month) && Number.isInteger(year)
      && day >= 1 && day <= 31 && month >= 1 && month <= 31 && year >= 1900) {
      for (let i = 0; i < bonds.length; i++) {
        //get the filtered bonds based on maturity date
        let rawDate = bonds[i]["bond_maturity_date"].split("/");
        let maturityDate = new Date(rawDate[2], rawDate[1] - 1, rawDate[0]).getTime();
        let nowDate = new Date(year, month - 1, day).getTime();
        if (Math.abs((nowDate - maturityDate) / 3600000) <= 7 * 24) {
          temIsin.add(bonds[i]["isin"])
        }
      }
      setWarning("");
      setIsin(temIsin);
      if (temIsin.size === 0) {
        setIsinnone("Sorry none available!")
      } else {
        setIsinnone("");
      }
    } else {
      setIsinnone("");
      setIsin(new Set());
      setWarning("Please enter the correct date format!");
    }
  }

  const logout = () => {
    props.getAuth(false);
    navigate('/');
  }


  for (let i = 0; i < bonds.length; i++) {
    deBonds.push(
      <>
        {Object.values(bonds[i]).map((value, index) => (
          <td key={index}>{value}</td>
        ))}
      </>
    );
  }

  // useEffect(() => {
  //   findBonds()
  //     .then(({data}) => {
  //       setBonds(data);
  //     })
  // }, []);

  useEffect(()=>{
    console.log(props.authState);
    if(!props.authState) {
      navigate("/");
    }
  }, []);

  return (
    <>
      <Button type='submit' onClick={logout}>Logout</Button>
      <Table responsive>
        <thead>
          {bonds.length !== 0 && <tr>{Object.keys(bonds[0]).map((bondKey, index) => (
            <th key={index}>{bondKey}</th>
          )
          )}</tr>}
        </thead>
        <tbody>
          {deBonds.length !== 0 && deBonds.map(ele => <tr>{ele}</tr>)}
        </tbody>
      </Table>
      <Card className={styles.card}>
        <Card.Header>Bonds due for maturity within 5 business days</Card.Header>
        <Form>
          <Form.Group className="mb-3">
            <Form.Label style={{ margin: "15px 0 -10px 16px" }}>Please enter your wished date here:</Form.Label>
            <Row>
              <Col>
                <Form.Control
                  type="text"
                  placeholder="Day/Month/Year"
                  value={date}
                  onChange={dateChange}
                  style={{ width: "100%", margin: "16px 0 0 16px" }}>
                </Form.Control>
              </Col>
              <Col><Button style={{ width: "38%", margin: "16px 0 0 16px" }} onClick={checkClick}>check</Button></Col>
            </Row>
          </Form.Group>
          <div style={{ color: "red", margin: "-10px 0 0 16px" }}>{warning}</div>
        </Form>
        <Card.Body>
          <Card.Title>The required bonds are shown below: </Card.Title>
          {isinnone === "" ? [...isin].map(ele => <Card.Text>{ele}</Card.Text>) : isinnone}
        </Card.Body>
      </Card>
    </>
  );
}
