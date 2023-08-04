package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "counter_party")
public class CounterParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "counterParty", cascade = CascadeType.ALL)
    private List<Trade> trades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

//    public List<Trade> getTrades() {
//        return trades;
//    }
//
//    public void setTrades(List<Trade> trades) {
//        this.trades = trades;
//    }

    @Override
    public String toString() {
        return "CounterParty{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", trades=" + trades +
                '}';
    }
}
