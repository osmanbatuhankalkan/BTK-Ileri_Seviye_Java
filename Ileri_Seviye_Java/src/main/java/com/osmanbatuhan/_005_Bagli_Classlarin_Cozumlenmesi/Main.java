package com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi;

import com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi.ICustomerDal;
import com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi.IocConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IocConfig.class);

        //Katmanlı mimarimiz (UI-Business-DataAccess)-(main.class-CustomerManager.clas-ICustomerDal.class)
        //Main'i 'UI(Arayüz)' olarak düşün o 'Servisi' çağrıyor.
        // Yani CustomerManager'i.
        // CustomerManager'da DAL'ları çağrıyor, yani ICustomerDal'ı(içerisinde onu implemente eden değerleri getiriyor.)

        ICustomerService customerService =context.getBean("service",ICustomerService.class);
        customerService.add();

    }
}
