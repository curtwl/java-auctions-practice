package com.curtwl.auctions.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String message;
    @ManyToOne
    private Item item;
    @ManyToOne
    private User user;
    private LocalDateTime createdAt;
    private Boolean isNew;
    private Boolean isRead;
    // getters and setters
}