package com.db.grad.javaapi.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
public class Bond implements Serializable {

    @Id
    @Column(name="id", insertable = false, updatable = false)
    private int id;

    @Column(name="isin")
    private String isin;

    @Column(name="bond_maturity_date")
    private String bond_maturity_date;

    @Column(name="cusip")
    private String cusip;

    @Column(name="issuer_name")
    private String issuer_name;

    @Column(name = "coupon")
    private float coupon;

    @Column(name = "type")
    private String type;

    @Column(name = "face_value")
    private float face_value;

    @Column(name = "bond_currency")
    private String bond_currency;

    @Column(name = "bond_status")
    private String bond_status;

    @Column(name = "trade_currency")
    private String trade_currency;

    @Column(name = "trade_status")
    private String trade_status;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private float unit_price;

    @Column(name = "buy_sell")
    private String buy_sell;

    @Column(name = "trade_date")
    private String trade_date;

    @Column(name = "settlement_date")
    private String settlement_date;

    @Column(name = "bond_holder")
    private String bond_holder;

    @Column(name = "book_name")
    private String book_name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(String bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
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

    public float getFace_value() {
        return face_value;
    }

    public void setFace_value(float face_value) {
        this.face_value = face_value;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getBond_status() {
        return bond_status;
    }

    public void setBond_status(String bond_status) {
        this.bond_status = bond_status;
    }

    public String getTrade_currency() {
        return trade_currency;
    }

    public void setTrade_currency(String trade_currency) {
        this.trade_currency = trade_currency;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getBuy_sell() {
        return buy_sell;
    }

    public void setBuy_sell(String buy_sell) {
        this.buy_sell = buy_sell;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(String settlement_date) {
        this.settlement_date = settlement_date;
    }

    public String getBond_holder() {
        return bond_holder;
    }

    public void setBond_holder(String bond_holder) {
        this.bond_holder = bond_holder;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "id=" + id +
                ", isin='" + isin + '\'' +
                ", bond_maturity_date='" + bond_maturity_date + '\'' +
                ", cusip='" + cusip + '\'' +
                ", issuer_name='" + issuer_name + '\'' +
                ", coupon=" + coupon +
                ", type='" + type + '\'' +
                ", face_value=" + face_value +
                ", bond_currency='" + bond_currency + '\'' +
                ", bond_status='" + bond_status + '\'' +
                ", trade_currency='" + trade_currency + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", buy_sell='" + buy_sell + '\'' +
                ", trade_date='" + trade_date + '\'' +
                ", settlement_date='" + settlement_date + '\'' +
                ", bond_holder='" + bond_holder + '\'' +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
