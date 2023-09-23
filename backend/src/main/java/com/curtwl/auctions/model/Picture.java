package com.curtwl.auctions.model;

import jakarta.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;
    private String altText;
    @ManyToOne
    private Item item;
    // getters and setters
}