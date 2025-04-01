package com.osman.hibernateDemo._003_Kosullu_Sorgular_Yazmak;

import com.osman.hibernateDemo._003_Kosullu_Sorgular_Yazmak.City;
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
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            /// ***** 1. Durum *****
            // List<City> cities = session.createQuery("from City c where c.countryCode='ISP' ").getResultList();
            //Burada dedikki: Şehirler Tablosundan Select et!(from City).
            //Where Koşulumuzu verdik (c where).
            //Sonrasında filtre edilecek kolon ve değeri verdik (c.countryCode='ISP')

            /// ***** 2. Durum *****
            // OR durumu içerisinde ISP veya USA geçen ülke kodlarını tablodan bulup getirir.
            //List<City> cities = session.createQuery("from City c where c.countryCode='ISP' OR c.countryCode='USA'").getResultList();

            /// ***** 3. Durum *****
            // AND durumu içerisinde ülke kodu(countryCode) olarak 'TUR' olan ve bölge(district) olarak 'Antalya' geçen tablodaki verileri bulup getirir.
            //List<City> cities = session.createQuery("from City c where c.countryCode='TUR' AND c.district='Antalya'").getResultList();

            /// ***** 4. Durum *****
            //LIKE kullanımı içerisinde geçen bizim bilirlediğmiz text'i tablomuzda arayacak olanları bulac ak getirecek.
            List<City> cities = session.createQuery("from City c where c.name LIKE '%kar%' ").getResultList();
            //% % ikisinin arasında varsa içerisinde var mı? diye bakar
            //% solda olursa başın bir önemi yok biten kısma bak.
            //--% sağda olursa sonun bir önemi yok başa bak.


            for (City city : cities) {
                System.out.println(city.getName());
            }

            session.getTransaction().commit();
        }finally{
            sessionFactory.close();
        }
    }
}

/*
* public class Main {
    public static void main(String[] args) {
        /// Session Fabrikası üretiyoruz.
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // config dosyasını oku
                .addAnnotatedClass(City.class)  // Entity sınıfını tanıt
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();// transactiona'a bağlanır, işlemi başlatır.

            //Select * from city; aşşağıdaki bununla aynı anlama gelir.
            List<City> cities = session.createQuery("from City").getResultList();/// Buraya bir Liste yazarak gelen datayı, buraya direk hızlıca çekeceğiz.

            for (City city : cities) {
                System.out.println(city.getName());
            }

            session.getTransaction().commit(); //işlem tamamlanır, veri tabanına bastırırız.
        }finally{
            sessionFactory.close(); // fabrika kapatılır, kaynakları serbest bırakırız.
        }
    }
}*/
/// ****
// Bir Session ve bir veri tabanımızın olduğunu düşünelim biz buraya veri tabanına bir sorgu yolluyoruz.
// Bir tane session açıyoruz, Session oturum anlamına gelir. Onun içinde sorgu yazıp, veritabınına yolluyoruz.
// Aslında biz Session kendisini yolluyoruz ve dolaylı olarak içeirisnde yazdığımız sorguda gitmiş oluyor.
// Peki neden Session oluşturuluyor ?
// Transaction yönetimi için. peki o ne dersek.
// Mesela biz bir insert yaptık, arkasından bir update yaptık.
// Bu Update'te bir sıkıntı olursa, bu Insert'te geri alınsın diye.
// Session Mantığı budur.
/// ****