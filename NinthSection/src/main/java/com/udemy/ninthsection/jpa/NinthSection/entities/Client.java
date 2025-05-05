package com.udemy.ninthsection.jpa.NinthSection.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private ClientDetails clientDetails;
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "client_id")
    @JoinTable(
        name = "tbl_clientes_to_direcciones", 
        joinColumns = @JoinColumn(name = "id_cliente"),
        inverseJoinColumns = @JoinColumn(name = "id_direcciones"), 
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"}))
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private Set<Invoice> invoices;

    public Client() {
        this.addresses = new HashSet<>();
        this.invoices = new HashSet<>();
    }
    public Client(String name, String lastname) {
        this.addresses = new HashSet<>();
        this.invoices = new HashSet<>();
        this.name = name;
        this.lastname = lastname;
    }
    public void addInvoices(Invoice... invoices){
        for (Invoice invoice : invoices) {
            this.invoices.add(invoice);
            invoice.setClient(this);
        }
    }
    public void removeInvoices(Invoice... invoices){
        for (Invoice invoice : invoices) {
            this.invoices.remove(invoice);
            invoice.setClient(null);
        }
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Set<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    public Set<Invoice> getInvoices() {
        return invoices;
    }
    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
    public ClientDetails getClientDetails() {
        return clientDetails;
    }
    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }
    @Override
    public String toString() {
        return "{id=" + id 
        + ", name=" + name 
        + ", lastname=" 
        + lastname 
        // + ", addresses=" + addresses 
        // + ", invoices=" + invoices 
        + ", client details=" + clientDetails
        + "}";
    }
}
