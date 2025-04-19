package com.javacourse.springBootDemo.DataAccess;

import com.javacourse.springBootDemo.Entities.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//JPA: ASlında başlangıçta bir veri erişim tekniği gibi, bir ORM olarak ortaya çıkmış olup, daha sonrasında javada bir standart haline geliyor.
//yani Hiberanette, springte otomatik Bu JPA yı implamante ediyor.
//Bunu implamante etmesinin sebebi şu oluyor, biz hızlı bir şekilde. Hangi implamantasyonu istiyorsak ona geçiyoruz.İster Hİbernate'e ister farklı bir ORM'e
//Bu noktada bizde bunu kullanıyor olcağız, hibernate dersinde oluşturduğumuz o section faktory ve o section nesnesi, otoamtik olarak burada injectionla oluşacak JPA'yı kullanarak.

@Repository
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
    /// ********************* ADD-UPDATE-DELETE ***************************
    @Override
    public void add(City city) {
    Session session= this.entityManager.unwrap(Session.class);
    session.saveOrUpdate(city);
    }
    //Burada iki kere aynı şeyi yazmış gibi olduk fakat, tecrübeyle sabit bu yapı daha kullanışlıymış.
    //Yukarıda add içerisinde if şart bloklarıyla, sistemsel yada kullanıcısal hataların önüne sorgularla geçebiliyormuşuz.
    //Örnek olarak if ile id 0 dan farklı mı? türünden sorgularla vs.
    @Override
    public void update(City city) {
        Session session= this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }
    @Override
    public void delete(City city) {
    Session session= this.entityManager.unwrap(Session.class);
    }
    /// ************************************************
    /// Burada veri tabanımızdaki tek bir nesmemizi çağıracak methodumuzu yazdık. Peki ne yaptık ? Önce HibernateCityDal classımızın atası olan ICityDal interface'ine gittik.
    /// Orada getById methodunu tanımladık ve geldik burada override ederek kullandık.
    @Override
    public City getById(int id) {
        Session session= this.entityManager.unwrap(Session.class);
        City city=session.get(City.class, id);
        return city;
    }
}
