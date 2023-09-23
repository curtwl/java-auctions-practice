package com.curtwl.auctions.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double bidAmount;
    @ManyToOne
    private Item item;
    @ManyToOne
    private User bidder;
    private LocalDateTime createdAt;
    private Boolean won;
    // getters and setters
}