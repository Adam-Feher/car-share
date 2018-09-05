package com.adamfeher.carshare.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "owner")
    private Set<Travel> createdTravels = new HashSet<>();
    private Set<Travel> joinedTravels = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Travel> getCreatedTravels() {
        return createdTravels;
    }

    public void setCreatedTravels(Set<Travel> createdTravels) {
        this.createdTravels = createdTravels;
    }

    public Set<Travel> getJoinedTravels() {
        return joinedTravels;
    }

    public void setJoinedTravels(Set<Travel> joinedTravels) {
        this.joinedTravels = joinedTravels;
    }
}
