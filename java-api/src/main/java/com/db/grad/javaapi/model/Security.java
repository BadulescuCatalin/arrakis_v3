package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
