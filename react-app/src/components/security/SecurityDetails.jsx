import React, { useState } from 'react'
import { Card, Dropdown } from 'react-bootstrap'

const SecurityDetails = (props) => {

    const [isser, setIssuer] = useState("");
    const [client, setClient] = useState("");
    
    const getIssuer = e => {
        setIssuer(props.info.issuer_name);
    }

    const getClientName = e => {
        setClient(props.info.client_name);
    }


    return (
        <Card >
            <Card.Body >
                <Card.Title >Bond: {props.info.id}</Card.Title>
                <Card.Text >Isin: {props.info.isin}</Card.Text>
                <Card.Text >Cusip: {props.info.cusip}</Card.Text>
                {isser && <Card.Text>Issuer: {isser}</Card.Text>}
                {client && <Card.Text>Client Name: {client}</Card.Text>}
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        More Details
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item onClick={getIssuer}>Issuer</Dropdown.Item>
                        <Dropdown.Item onClick={getClientName}>Client Name</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
            </Card.Body>

        </Card>
    )
}


export default SecurityDetails