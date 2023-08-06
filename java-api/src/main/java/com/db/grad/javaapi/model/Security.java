package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isin")
    private String isin;

    @Column(name = "cusip")
    private String cusip;

    @Column(name = "issuer_name")
    private String issuer_name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    @Column(name = "maturity_date")
    private Date maturity_date;

    @Column(name = "coupon")
    private float coupon;

    @Column(name = "type")
    private String type;

    @Column(name = "face_value")
    private String face_value;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL)
    private List<Trade> trades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssin() {
        return isin;
    }

    public void setIssin(String issin) {
        this.isin = issin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public Date getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(Date maturity_date) {
        this.maturity_date = maturity_date;
    }

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFace_value() {
        return face_value;
    }

    public void setFace_value(String face_value) {
        this.face_value = face_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public List<Trade> getTrades() {
//        return trades;
//    }
//
//    public void setTrades(List<Trade> trades) {
//        this.trades = trades;
//    }

//    @Override
//    public String toString() {
//        return "Security{" +
//                "id=" + id +
//                ", issin='" + issin + '\'' +
//                ", cusip='" + cusip + '\'' +
//                ", issuer_name='" + issuer_name + '\'' +
//                ", maturity_date='" + maturity_date + '\'' +
//                ", coupon=" + coupon +
//                ", type='" + type + '\'' +
//                ", face_value='" + face_value + '\'' +
//                ", currency='" + currency + '\'' +
//                ", status='" + status + '\'' +
//                ", trades=" + trades +
//                '}';
//    }
}
