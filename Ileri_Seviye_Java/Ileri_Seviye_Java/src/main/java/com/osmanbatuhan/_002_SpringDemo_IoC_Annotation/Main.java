package com.osmanbatuhan._002_SpringDemo_IoC_Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextSpringDemoIoC.xml");//Xml yolunu gösterdik,bağladık

        ICustomerDal customerDal =context.getBean("database",ICustomerDal.class);//Bu satır: 'ICustomerDal' için 'database'de ne yazıyorsa onu
        // 'new'le bana ver demek. 'applicationContextSpringDemoIoc.xml' dosyamıza gidiyor fakat bu sefer içerisi boş, önceden olsa database 'id' yi bulur,
        //ona göre işlem yapardı.Bu noktada işte 'Anatasyonlar' devreye giriyor.
        //Nasıl uygulayacağız? dersek herhangi bir Dal classa giderek sınıfın başına @Component("database") yazmamız gerekiyor.Bu işlemi uyguladıktan sonra,
        //Son bir adim kalıyor, oda 'applicationContextSpringDemoIoC.xml' içerisine, git bütün sınıfınların başına bak @Component("database") tanımlanmış mı ?
        // eğer tanımlı ise, onu new'le onu ver diyecek olan,'component-scan' özelliğiyle oluyor.
        customerDal.add();

    }
}
