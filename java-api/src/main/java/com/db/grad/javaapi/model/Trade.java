package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
    private Book book;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "security_id", referencedColumnName = "id", nullable = false)
    private Security security;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "counter_party_id", referencedColumnName = "id", nullable = false)
    private CounterParty counterParty;

    @Column(name = "currency")
    private String currency;
    @Column(name = "status")
    private String status;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price")
    private float unit_price;
    @Column(name = "buy_sell")
    private String buy_sell;
    @Column(name = "trade_date")
    private Date trade_date;
    @Column(name = "settlement_date")
    private Date settlement_date;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public CounterParty getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(CounterParty counterParty) {
        this.counterParty = counterParty;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public Date getSettlement_date() {
        return settlement_date;
    }

    public void setSettlement_date(Date settlement_date) {
        this.settlement_date = settlement_date;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", book=" + book +
                ", security=" + security +
                ", counterParty=" + counterParty +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", unit_price=" + unit_price +
                ", buy_sell='" + buy_sell + '\'' +
                ", trade_date='" + trade_date + '\'' +
                ", settlement_date='" + settlement_date + '\'' +
                '}';
    }
}
