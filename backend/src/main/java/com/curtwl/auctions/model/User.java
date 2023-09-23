package com.curtwl.auctions.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private LocalDateTime emailVerified;
    private String image;
    @OneToMany(mappedBy = "seller")
    private List<Item> itemsForSale;
    @OneToMany(mappedBy = "purchasedBy")
    private List<Item> itemsPurchased;
    @OneToMany
    private List<Address> addresses;
    @OneToMany(mappedBy = "bidder")
    private List<Bid> bids;
    @ManyToMany(mappedBy = "bidders")
    private List<Item> biddingOn;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    // getters and setters
}