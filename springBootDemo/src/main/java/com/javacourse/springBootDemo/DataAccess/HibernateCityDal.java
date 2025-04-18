package com.javacourse.springBootDemo.DataAccess;

import com.javacourse.springBootDemo.Entities.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//JPA: ASlında başlangıçta bir veri erişim tekniği gibi, bir ORM olarak ortaya çıkmış olup, daha sonrasında javada bir standart haline geliyor.
//yani Hiberanette, springte otomatik Bu JPA yı implamante ediyor.
//Bunu implamante etmesinin sebebi şu oluyor, biz hızlı bir şekilde. Hangi implamantasyonu istiyorsak ona geçiyoruz.İster Hİbernate'e ister farklı bir ORM'e
//Bu noktada bizde bunu kullanıyor olcağız, hibernate dersinde oluşturduğumuz o section faktory ve o section nesnesi, otoamtik olarak burada injectionla oluşacak JPA'yı kullanarak.

public class HibernateCityDal implements ICityDal{

    private EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
        //Buradaki asıl mevzu şu, önceden olan section factory'i bu şekilde otomatik enjekte edicez.
        //Bunuda @Autowired anatasyonuyla yaparız.
    }

    //AOP - Aspect Oriented Programming
    @Override
    @Transactional

    public List<City> getAll() {
       Session session= this.entityManager.unwrap(Session.class);//JPA Hibernate ile ilgili tüm bağlantıları bizim yerimize gerçekleştiriyor.
        List<City> cities=session.createQuery("from City",City.class).getResultList();
        return cities;
        //Hibernate ile JPA kullanarak çok hızlı kodlamış olduk.
        //tüm şehirleri listeliyebiliriz şuan.
    }

    @Override
    public void add(City city) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(City city) {

    }
}
