package com.osmanbatuhan._001_Ileri_Seviye_Java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//Xml yolunu gösterdik,bağladık
        //CustomerManager manager = new CustomerManager(context.getBean("database",ICustomerDal.class));
        /// Arka planda bize newlenmiş halini getirir bizi 100lerce newlenmiş yapı yazmaktan kurtarır.
        /// Değişiklik yapmakisteidğimizde sadece class ismi değiştirmek yeterli örn:<bean id="database" class="com.osmanbatuhan.Ileri_Seviye_Java.CustomerDal">
        /// Birinde oracle veri tab. gelirken diğerinde myslq veri. tab. gelir.
    ///        <bean id="database" class="com.osmanbatuhan.Ileri_Seviye_Java.MysqlCustomerDal">
       ///         </bean>

        ICustomerService customerService =context.getBean("service",ICustomerService.class);//Bu CustomerManager'in new'ini vermiş oldu
        customerService.add();

    }
}
