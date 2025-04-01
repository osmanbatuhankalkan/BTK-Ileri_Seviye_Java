package com.osman.hibernateDemo._002_Ilk_Sorgu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /// Session Fabrikası üretiyoruz.
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // config dosyasını oku
                .addAnnotatedClass(com.osman.hibernateDemo._002_Ilk_Sorgu.City.class)  // Entity sınıfını tanıt
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        /// ** Uygulama açılırken oluşur ve sonra bu fabrika kullanılır.
        /// ** Artık fabrika oluştu buna bir oturum almamız lazım.

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
}
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