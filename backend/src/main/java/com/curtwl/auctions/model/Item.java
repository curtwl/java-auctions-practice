package com.curtwl.auctions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<Picture> pictures;
    @ManyToOne
    private User seller_id;
    private Boolean sold;
    @ManyToOne
    private User purchasedBy_id;
    private String category;
    private String condition;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
    private Double buyNowPrice;
    private Double startingBid;
    private Double reservePrice;
    @ManyToMany
    private List<User> bidders_id;
    @OneToMany(mappedBy = "item")
    private List<Bid> bids;
    private Boolean auctionEnded;
    @OneToMany(mappedBy = "item")
    private List<Notification> notifications;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

//    public void setPictures(List<Picture> pictures) {
//        this.pictures = pictures;
//    }

    public User getSeller_id() {
        return seller_id;
    }

//    public void setSeller(User seller) {
//        this.seller = seller;
//    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public User getPurchasedBy_id() {
        return purchasedBy_id;
    }

//    public void setPurchasedBy(User purchasedBy) {
//        this.purchasedBy = purchasedBy;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(Double startingBid) {
        this.startingBid = startingBid;
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public List<User> getBidders_id() {
        return bidders_id;
    }

//    public void setBidders(List<User> bidders) {
//        this.bidders = bidders;
//    }

    public List<Bid> getBids() {
        return bids;
    }

//    public void setBids(List<Bid> bids) {
//        this.bids = bids;
//    }

    public Boolean getAuctionEnded() {
        return auctionEnded;
    }

    public void setAuctionEnded(Boolean auctionEnded) {
        this.auctionEnded = auctionEnded;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}