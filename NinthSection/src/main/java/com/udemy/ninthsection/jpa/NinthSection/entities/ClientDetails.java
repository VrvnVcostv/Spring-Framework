package com.udemy.ninthsection.jpa.NinthSection.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean premium;
    private int points;

    @OneToOne
    @JoinColumn(name = "id_client_table")
    private Client client;

    public ClientDetails() {
    }
    public ClientDetails(boolean premium, int points) {
        this.premium = premium;
        this.points = points;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "{id=" + id 
            + ", premium=" + premium 
            + ", points=" + points + "}";
    }
    
    
}
