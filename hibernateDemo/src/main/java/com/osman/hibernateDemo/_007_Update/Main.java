package com.osman.hibernateDemo._007_Update;

import com.osman.hibernateDemo._007_Update.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            //UPDATE
            //önce Data geliyor mu? bir bakalım.
            City city = session.get(City.class, 1);

            // System.out.println(city.getDistrict());
            // Geliyormus.
            //Artık bu data geldiğinee göre biz istediğimiz kolonda güncelleme yapabiliriz.
            //** Fakat önemli nokta şurada SET ile güncelleme yaptıktan sonra mutlaka SAVE ile kaydetmeliyiz.
            /// INSERT ve UPDATE arasındaki farkta, birisinin sıfırdan bir şey oluştururken, diğeri ise var olan bir şeyi değiştirir.
            /// İkisinde de ortak olarak save() method kullanıyoruz.

            city.setName("AdAnA");
            city.setPopulation(99999999);
            city.setCountryCode("ADN");
            session.save(city);
            session.getTransaction().commit();
            System.out.println("Sehir başarıyla güncellendi.");

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




///// Bir şehir eklemek istediğimizi varsayalım. Şu şekilde yapacağız.
//City city = new City();
//            city.setName("London");
//            city.setCountryCode("GBR");
//            city.setDistrict("Greater London");
//            city.setPopulation(8982000);
//
//        session.save(city);
////Bu save işleminin tamamı başaralı olmak zorundadır. Yoksa Transaction uygular hepsini iptal eder.
////ek olarak city2 vs bir şeyler eklemek istekte geçerli
//            System.out.println("Sehir Basarıyla eklendi.");