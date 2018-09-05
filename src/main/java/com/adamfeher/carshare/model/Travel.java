package com.adamfeher.carshare.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Travel {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User owner;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startingTime;
    private String startingPlace;
    private String arrivingPlace;
    private Position startingPosition;
    private int numberOfSeats;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return owner;
    }

    public void setUserId(long userId) {
        this.owner = userId;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getArrivingPlace() {
        return arrivingPlace;
    }

    public void setArrivingPlace(String arrivingPlace) {
        this.arrivingPlace = arrivingPlace;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public Position getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(Position startingPosition) {
        this.startingPosition = startingPosition;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
