package com.osmanbatuhan._004_IoC_Config_Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //eski Xml 'ClassPathXml' versionu olan kısmı günceli 'AnnotationConfig' ile değiştiriyoruz.

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IocConfig.class);//Config dosyasının yolunu ne olduğunu gösterdik,bağladık
        /// İlgili config dosyasına gidecek,'IocConfig.java'.@ComponentScan("com.osmanbatuhan")'daki tüm classları arayacak.
        /// Kim için arayacak aşşağıdaki "database" için. Hangi sınıfta bulursada onun için uygulamamız çalışıyor olacak.

        com.osmanbatuhan._004_IoC_Config_Bean.ICustomerDal customerDal =context.getBean("database", ICustomerDal.class);
        customerDal.add();

    }
}
/// eski _002_nin kodları kıyas açısından buraya açıklama satırına alıyorum.
/*
* public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextSpringDemoIoC.xml");//Xml yolunu gösterdik,bağladık

        com.osmanbatuhan._002_SpringDemo_IoC_Annotation.ICustomerDal customerDal =context.getBean("database", ICustomerDal.class);//Bu satır: 'ICustomerDal' için 'database'de ne yazıyorsa onu
        // 'new'le bana ver demek. 'applicationContextSpringDemoIoc.xml' dosyamıza gidiyor fakat bu sefer içerisi boş, önceden olsa database 'id' yi bulur,
        //ona göre işlem yapardı.Bu noktada işte 'Anatasyonlar' devreye giriyor.
        //Nasıl uygulayacağız? dersek herhangi bir Dal classa giderek sınıfın başına @Component("database") yazmamız gerekiyor.Bu işlemi uyguladıktan sonra,
        //Son bir adim kalıyor, oda 'applicationContextSpringDemoIoC.xml' içerisine, git bütün sınıfınların başına bak @Component("database") tanımlanmış mı ?
        // eğer tanımlı ise, onu new'le onu ver diyecek olan,'component-scan' özelliğiyle oluyor.
        customerDal.add();

    }
}
* */