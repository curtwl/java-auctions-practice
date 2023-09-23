package com.curtwl.auctions.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "item")
    private List<Picture> pictures;
    @ManyToOne
    private User seller;
    private Boolean sold;
    @ManyToOne
    private User purchasedBy;
    private String category;
    private String condition;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
    private Double buyNowPrice;
    private Double startingBid;
    private Double reservePrice;
    @ManyToMany
    private List<User> bidders;
    @OneToMany(mappedBy = "item")
    private List<Bid> bids;
    private Boolean auctionEnded;
    private Double soldPrice;
    @OneToMany(mappedBy = "item")
    private List<Notification> notifications;

    // getters and setters
}