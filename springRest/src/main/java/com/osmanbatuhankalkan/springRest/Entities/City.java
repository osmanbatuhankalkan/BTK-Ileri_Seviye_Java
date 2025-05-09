package com.osmanbatuhankalkan.springRest.Entities;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.*;

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

    @Column(name="name")
    private String name;

    @Column(name="countryCode")
    private String countryCode;

    @Column(name="district")
    private String district;

    @Column(name="population")
    private int population;

    // JPA için zorunlu parametresiz constructor:
    protected City() { }

    public City(int id, String name, String countryCode, String district, int population) {
        super();
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
