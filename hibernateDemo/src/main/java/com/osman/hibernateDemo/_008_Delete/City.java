package com.osman.hibernateDemo._008_Delete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/// ** Burada MySql veri tabanızımıda city tablosuna karşılık gelen Nesnemizi oluşturuyoruz.
/// Sonrasında zaten Bunları MAP edeceğiz. Yani birbirlerine bağlayacağız.
/// Nedir bu entity? Şu an bu city nesnesi bir entitydir, yani bir veri tabanı nesnesidir..

@Entity
@Table(name="city") //Hangi tabloya karşılık gelecek onun cevabı
public class City {
    ///****** Peki tabloyu bağladık, kolonları nasıl bağlayacağız dersek ? aşşağıdaki gibi
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="CountryCode")
    private String countryCode;

    @Column(name="District")
    private String district;

    @Column(name="Population")
    private int population;
    ///****** İşte Biz tamda bu şekilde City nesnesini, veri tabanındaki city tablosuyla MAP etmiş olduk(@Column ile hangi veri tablosuan denk geleceğini belirliyoruz.).
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
