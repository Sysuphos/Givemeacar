package com.example.Givemeacar.model;


import javax.persistence.*;


//@ = JPA anotation used to map this model to our listner database table
@Entity
//provide table name
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "agency")
    private String agency;

    @Column(name = "marque")
    private String marque;

    @Column(name = "model")
    private String model;

    @Column(name = "kilometrage")
    private Integer kilometrage;

    @Column(name = "availability")
    private Boolean isAvailable;

    @Column(name = "etat")
    private String etat;

    //Default constructor
    public Car() {

    }
    //Parameters constructor
    public Car(String agency, String marque, String model, Integer kilometrage, Boolean isAvailable, String etat) {
        this.agency = agency;
        this.marque = marque;
        this.model = model;
        this.kilometrage = kilometrage;
        this.isAvailable = isAvailable;
        this.etat = etat;
    }

    // Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
