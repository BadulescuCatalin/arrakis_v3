import React, { useState } from 'react'
import { Card, Dropdown } from 'react-bootstrap'

const BondDetails = (props) => {

    return (
        <Card >
            <Card.Body >
                <Card.Title >Bond {props.info.id}</Card.Title>
                <Card.Text >Isin: {props.info.isin}</Card.Text>
                <Card.Text >Cusip: {props.info.cusip}</Card.Text>
                <Card.Text >Issuer Name: {props.info.issuer_name}</Card.Text>
                <Card.Text >Currency: {props.info.currency}</Card.Text>
                <Card.Text >Face Value: {props.info.face_value}</Card.Text>
                <Card.Text >Trade Date: {props.info.trade_date}</Card.Text>
                <Card.Text >Maturity Date: {props.info.maturity_date}</Card.Text>
                <Card.Text >Status: {props.info.status}</Card.Text>
                <Card.Text >Type: {props.info.type}</Card.Text>
            </Card.Body>

        </Card>
    )
}


export default BondDetails