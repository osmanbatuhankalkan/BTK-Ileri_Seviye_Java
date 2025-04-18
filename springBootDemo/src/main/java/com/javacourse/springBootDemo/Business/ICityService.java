package com.javacourse.springBootDemo.Business;

import com.javacourse.springBootDemo.Entities.City;

import java.util.List;
//DataAccess'teki ICityDal'daki, Aynı şeyleri yapacaksak. Neden Burada da aynı şeyleri yazdık diye akıla bir soru gelebilir.
// Businessta sırf iş kurallarını kontrol edebilmek için, veri tabanına göndermeyeğizdir. Fakat bir true, false değeri gönderebiliriz.
// Business katmanındaki bu imzalar, bunlara imza deniyor. Zamanla değişebiliyor.O yüzden birbirinden ayırıyoruz.
//Bunun birde iş classına ihtiyacı var. Onuda 'CityManager' diye tarif edeceğiz. İmplements'ini ICityService'den alacak.
public interface ICityService {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);

}
