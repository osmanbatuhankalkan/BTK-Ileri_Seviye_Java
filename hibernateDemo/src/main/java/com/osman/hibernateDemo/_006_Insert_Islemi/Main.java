package com.osman.hibernateDemo._006_Insert_Islemi;

import com.osman.hibernateDemo._004_Order_By_Islemleri.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(City.class)
                .buildSessionFactory();
        //Unit of work tasarım deseninin uygulanmış halidir.
        Session session = sessionFactory.getCurrentSession();
        try{
            //Bu session aslında unıt of work tasarım desenidir. Onun uygulanmış hali komple bu yaptığımız işlemler.
            session.beginTransaction();
        /// Bir şehir eklemek istediğimizi varsayalım. Şu şekilde yapacağız.
            City city = new City();
            city.setName("London");
            city.setCountryCode("GBR");
            city.setDistrict("Greater London");
            city.setPopulation(8982000);

        session.save(city);
        //Bu save işleminin tamamı başaralı olmak zorundadır. Yoksa Transaction uygular hepsini iptal eder.
            //ek olarak city2 vs bir şeyler eklemek istekte geçerli
            System.out.println("Sehir Basarıyla eklendi.");
            session.getTransaction().commit();
        }finally{
            sessionFactory.close();
        }
    }
}
//List<String> countryCodes = session.createQuery("Select c.countryCode from City c Group By c.countryCode ").getResultList();
//
//            for (String countryCode : countryCodes) {
//                System.out.println(countryCode);
//            }