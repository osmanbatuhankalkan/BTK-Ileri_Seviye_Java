package com.javacourse.springBootDemo.DataAccess;
import com.javacourse.springBootDemo.Entities.City;
import java.util.List;

/// VERİ ERİŞİM INTERFACE'i
/// 'ICity' DATA ACESS LAYER daki bir interface anlamına gelir 'City' için.

public interface ICityDal {

    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(int id);

}
