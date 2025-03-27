package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerService;
import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.IocConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(IocConfig.class);

        /// Bir adet 'values.properties' dosyamız var,'IocConfig'e gelip bir tane anatasyon(@PropertySource()) ekledik.
        /// Sonra kullanmak istediğimiz yerlerde, ilgili classlarda @Value("${}") içerisinde valuesproperties içerisinde belirlediğimiz değişken ismini yazarak çağırdık.
        com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerService customerService =context.getBean("service", ICustomerService.class);
        customerService.add();

    }
}
