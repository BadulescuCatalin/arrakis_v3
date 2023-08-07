import React from 'react'
import Row from 'react-bootstrap/Row'
import Button from 'react-bootstrap/esm/Button'
import { Col } from 'react-bootstrap'
import { Card } from 'react-bootstrap'

const SecurityDetails = (props) => {
    const viewMoreDetails = () => {
        console.log(props.info);
    }
    return (
        <Card >
            <Card.Body >
                <Card.Title >Bond: {props.info.id}</Card.Title>
                <Card.Text >Isin: {props.info.issin}</Card.Text>
                <Card.Text >Cusip: {props.info.cusip}</Card.Text>
                <Card.Text >Bond_holder: {props.info.bond_holer}</Card.Text>
                <Row>
                    <Col><Button variant="primary" onClick={viewMoreDetails}>View More Details</Button></Col>
                </Row>
            </Card.Body>
        </Card>
    )
}


export default SecurityDetails