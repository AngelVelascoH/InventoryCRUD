package com.angel.inventorycrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Location {
    @Id
    @Column(name = "locationId")
    private int locationId;
    @Column(name = "state")
    private String state;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private int phoneNumber;

    @OneToOne(mappedBy = "location")
    private Item theItem;


    public Location(){
    }
    public Location(int locationId, String state, String address, int phoneNumber) {
        this.locationId = locationId;
        this.state = state;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "location{" +
                "locationId=" + locationId +
                ", state='" + state + '\'' +
                ", adress='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

