package com.angel.inventorycrud.entity;

import com.angel.inventorycrud.entity.Location;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @Column(name = "itemId")
    private int itemId;
    @Column(name="itemName")
    private String itemName;
    @Column(name="description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_Id")
    private Location location;

}
