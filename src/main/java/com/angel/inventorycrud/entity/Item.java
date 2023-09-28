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

    public Item(){}

    public Item(int itemId, String itemName, String description, Location location) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.location = location;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                '}';
    }
}
