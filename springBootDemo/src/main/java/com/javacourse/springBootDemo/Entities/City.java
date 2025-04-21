package com.javacourse.springBootDemo.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


//Bir veri tabanı nesnesi olduğunu anlatan @Entitiy
@Entity
@Table(name="city")
public class City {
//Bu tablomuzu şimdi veri tabanımızla bağlamamız gerekiyor.
    //Bu tabloya sen bir veri tabanı tablosusun diyip, veri tabanı tablosu olduğunu belirtmemiz gerekiyor.
    //onuda bir anatasyon ile yapacağız. @Table(name="")

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik id artışı olacağını bu şekilde belirtiriz.
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Countrycode")
    private String countryCode;

    @Column(name="District")
    private String district;

    @Column(name="Population")
    private int population;

    // JPA için zorunlu parametresiz constructor:
    protected City() { }

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}