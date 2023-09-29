package com.curtwl.auctions.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private LocalDateTime emailVerified;
    private String image;
    @OneToMany(mappedBy = "seller_id", fetch = FetchType.LAZY)
    private List<Item> itemsForSale;
    @OneToMany(mappedBy = "purchasedBy_id", fetch = FetchType.LAZY)
    private List<Item> itemsPurchased;
    @OneToMany
    private List<Address> addresses;
    @OneToMany(mappedBy = "bidder")
    private List<Bid> bids;
    @ManyToMany(mappedBy = "bidders_id", fetch = FetchType.LAZY)
    private List<Item> biddingOn;
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(LocalDateTime emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public List<Item> getItemsPurchased() {
        return itemsPurchased;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public List<Item> getBiddingOn() {
        return biddingOn;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

//    public String getRoles() {
//        return "ADMIN";
//    }
}