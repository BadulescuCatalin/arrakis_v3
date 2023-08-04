import React, { useState } from 'react';
import { Button, Form, Row, Card } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import { userLogin } from '../../services/BondServices';
import styles from "./Auth.module.css";

const Auth = (props) => {

    const dummyData = [
        {
            "email": "test@test.com",
            "password": "test"
        },
        {
            "email": "test2@test.com",
            "password": "test2"
        }
    ];

    const navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [isAutheticated, setIsAuthenticated] = useState(false);
    const [warning, setWarning] = useState("");

    const emailChange = e => {
        setEmail(e.target.value);
        setWarning("");
    }

    const passwordChange = e => {
        setPassword(e.target.value);
        setWarning("");
    }

    const login2 = (e) => {
        e.preventDefault();
        const credentials = {};
        credentials.email = email;
        credentials.password = password;
        
        userLogin(credentials)
        .then(res => {
            console.log(res);
            setIsAuthenticated(true);
            setWarning("");
            props.getAuth(true);
            navigate("/bonds");
        })
        .catch(err => {
            setIsAuthenticated(false);
            setWarning("Wrong Credentials!");

        })
    }

    const login = (e) => {
        e.preventDefault();
        const user = dummyData.find(ele => ele.email === email);
        if (user) {
            if (user.password === password) {
                setIsAuthenticated(true);
                setWarning("");
                navigate("/bonds");
                props.getAuth(true);
            } else {
                setIsAuthenticated(false);
                setWarning("The password is incorrect!")
            }
        } else {
            setIsAuthenticated(false);
            setWarning("The email address is invalid!")
        }
    }

    return (
        <>
            <Row className={styles.authForm}>
                <Form>
                    <Form.Group className='mb-3'>
                        <Form.Label>Email</Form.Label>
                        <Form.Control type="email" value={email} onChange={emailChange}></Form.Control>
                    </Form.Group>
                    <Form.Group className='mb-3'>
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" value={password} onChange={passwordChange}></Form.Control>
                    </Form.Group>
                    <Button type='submit' onClick={login2}>Login</Button>
                </Form>
            </Row>
            {warning && <Card className={styles.warningCard}>
                <Card.Body>{warning}</Card.Body>
            </Card>}
        </>

    )
}

export default Auth;