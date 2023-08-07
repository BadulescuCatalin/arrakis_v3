import React, { useEffect } from 'react'
import SecurityDetails from './SecurityDetails'
import { Button, Row, Col, Form, Card } from 'react-bootstrap'
import { useState } from 'react'
import { findBonds, maturitySearch, isinSearch } from '../../services/BondServices'
import { Nav } from 'react-bootstrap'
import { Navbar } from 'react-bootstrap'
import { Dropdown } from 'react-bootstrap'
import styles from "../bonds/Bonds.module.css";
import { useNavigate } from "react-router-dom";

const AllSecurities = (props) => {

    const [bonds, setBonds] = useState([]);
    const [date, setDate] = useState("");
    const [warning, setWarning] = useState("");
    const [identifier, setIdentifier] = useState("");
    const [deBonds, setDeBonds] = useState([]);
    const navigate = useNavigate();
    const allBonds = [];

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

    const checkClick = e => {
        e.preventDefault();

        let enteredDate = date.split("/");
        let day = +enteredDate[0];
        let month = +enteredDate[1];
        let year = +enteredDate[2];
        if (Number.isInteger(day) && Number.isInteger(month) && Number.isInteger(year)
            && day >= 1 && day <= 31 && month >= 1 && month <= 31 && year >= 1900) {
            setDate(enteredDate);
            const dateMap = {
                date
            };
            maturitySearch(dateMap)
                .then(({ data }) => {
                    console.log(data);
                    setSecurities(data);
                    setDate("");
                    setWarning("");
                })
                .catch(error => {
                    setDate("");
                    console.log(dateMap);
                    console.error("Error occurred during API call:", error);
                    // Handle the error as needed, e.g., set an error message state
                });
        } else {
            setWarning("Please enter the correct date format!");
        }
    }
    const checkClick2 = e => {
        e.preventDefault();
        const map = {
            "data": identifier
        };
        isinSearch(map)
            .then(({ data }) => {
                setBonds(data);
            })
    }

    const logout = () => {
        props.getAuth(false);
        navigate('/');
    }

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
    useEffect(() => {
        findBonds()
            .then(({ data }) => {
                setBonds(data);
            })
    }, []);


    // router guard
    useEffect(() => {
        console.log(props.authState);
        if (!props.authState) {
            navigate("/");
        }
    }, []);


    const [searchBy, setSearchBy] = useState('All Bonds');
    const handleOptionSelect = (option) => {
        if (option === '1') {
            setSearchBy('All Bonds');
            //setSecurities();
        } else {
            setSearchBy('My Books');
            //setSecurities();
        }
    };
    const [securities, setSecurities] = useState([]);

    useEffect(() => {
        getSecuritiesFromAPI();
    },
        []
    )

    const getSecuritiesFromAPI = () => {
        findBonds()
            .then(res => {
                setSecurities(res.data);
            })
            .catch(err => {
                setSecurities([]);
                console.log(err);
            })
    }
    return (
        <>
            <Navbar bg="light" expand="lg">
                <Navbar.Brand> Securities</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Dropdown>
                            <Dropdown.Toggle variant="success" id="dropdown-basic">
                                Search by: {searchBy}
                            </Dropdown.Toggle>
                            <Dropdown.Menu>
                                <Dropdown.Item onClick={() => handleOptionSelect('1')}>All Bonds</Dropdown.Item>
                                <Dropdown.Item onClick={() => handleOptionSelect('2')}>My Books</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            <Row>
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

            </Row>
            <Row>
                {securities.map(security => (
                    <div className='container' key={security.id}>
                        <SecurityDetails info={security} />
                    </div>
                ))}
            </Row>
        </>
    );
}

export default AllSecurities