package com.curtwl.auctions.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private Integer zip;
    private String addressType;
    @ManyToMany(mappedBy = "addresses")
    private List<User> users;
    // getters and setters
}