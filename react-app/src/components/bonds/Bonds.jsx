import React, { useState, useEffect } from "react";
import { findBonds, isinSearch, maturitySearch } from "../../services/BondServices";
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
    "isin": "XS1988387210",
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
  const [warning, setWarning] = useState("");
  const [identifier, setIdentifier] = useState("");
  const [deBonds, setDeBonds] = useState([]);
  const navigate = useNavigate();
  const allBonds = dummyData;

  //local test version
  const dateChange = e => {
    setDate(e.target.value);
    setBonds(allBonds);
    setWarning("");
  }

  //local test version
  const identifierChange = e => {
    setIdentifier(e.target.value);
    setBonds(allBonds);
  }

  // local test version
  const checkClick = e => {
    e.preventDefault();
    let enteredDate = date.split("/");
    let day = +enteredDate[0];
    let month = +enteredDate[1];
    let year = +enteredDate[2];
    let temp = [];
    if (Number.isInteger(day) && Number.isInteger(month) && Number.isInteger(year)
      && day >= 1 && day <= 31 && month >= 1 && month <= 31 && year >= 1900) {
      for (let i = 0; i < bonds.length; i++) {
        //get the filtered bonds based on maturity date
        let rawDate = bonds[i]["bond_maturity_date"].split("/");
        let maturityDate = new Date(rawDate[2], rawDate[1] - 1, rawDate[0]).getTime();
        let nowDate = new Date(year, month - 1, day).getTime();
        if (Math.abs((nowDate - maturityDate) / 3600000) <= 7 * 24) {
          temp.push(bonds[i])
        }
      }
      setBonds(temp);
      setWarning("");
    } else {
      setWarning("Please enter the correct date format!");
    }
  }

  // backend interaction version
  // const checkClick = e => {
  //   e.preventDefault();

  //   let enteredDate = date.split("/");
  //   let day = +enteredDate[0];
  //   let month = +enteredDate[1];
  //   let year = +enteredDate[2];
  //   if (Number.isInteger(day) && Number.isInteger(month) && Number.isInteger(year)
  //     && day >= 1 && day <= 31 && month >= 1 && month <= 31 && year >= 1900) {
  //     maturitySearch(date)
  //       .then(({ data }) => {
  //         console.log(data);
  //         setBonds(data);
  //         setWarning("");
  //       })
  //   } else {
  //     setWarning("Please enter the correct date format!");
  //   }
  // }

  // local test version
  const checkClick2 = e => {
    e.preventDefault();
    const filteredBonds = [].concat(allBonds.filter(ele => ele.isin === identifier || ele.cusip === identifier));
    setBonds(filteredBonds);
  }

  // backend interaction version
  // const checkClick2 = e => {
  //   e.preventDefault();
  //   isinSearch(isin)
  //     .then(({ data }) => {
  //       setBonds(data);
  //     })
  // }

  const logout = () => {
    props.getAuth(false);
    navigate('/');
  }

  // get all the values of corresponding columns
  const getDeBonds = () => {
    let temp = [];
    for (let i = 0; i < bonds.length; i++) {
      temp.push(
        <>
          {Object.values(bonds[i]).map((value, index) => (
            <td key={index}>{value}</td>
          ))}
        </>
      );
    }
    setDeBonds(temp);
  }

  // as long as the bonds change, call the getDeBonds function again
  useEffect(() => {
    getDeBonds();
  }, [bonds]);

  // get all the bonds for the initial render
  // useEffect(() => {
  //   findBonds()
  //     .then(({data}) => {
  //       setBonds(data);
  //     })
  // }, []);


  // router guard
  // useEffect(()=>{
  //   console.log(props.authState);
  //   if(!props.authState) {
  //     navigate("/");
  //   }
  // }, []);

  return (
    <>
      <Button type='submit' onClick={logout} className={styles.logout}>Logout</Button>

      <Table responsive>
        <thead>
          {<tr>{Object.keys(allBonds[0]).map((bondKey, index) => (
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
          {warning && <div style={{ color: "red", margin: "-10px 0 0 16px" }}>{warning}</div>}
        </Form>
      </Card>

      <Card className={styles.card}>
        <Card.Header>Find the data you want from ISIN or CUSIP</Card.Header>
        <Form>
          <Form.Group className="mb-3">
            <Form.Label style={{ margin: "15px 0 -10px 16px" }}>Please enter your wished ISIN or CUSIP here:</Form.Label>
            <Row>
              <Col>
                <Form.Control
                  type="text"
                  placeholder="ISIN or CUSIP"
                  value={identifier}
                  onChange={identifierChange}
                  style={{ width: "100%", margin: "16px 0 0 16px" }}>
                </Form.Control>
              </Col>
              <Col><Button style={{ width: "38%", margin: "16px 0 0 16px" }} onClick={checkClick2}>check</Button></Col>
            </Row>
          </Form.Group>
        </Form>
      </Card>
    </>
  );
}