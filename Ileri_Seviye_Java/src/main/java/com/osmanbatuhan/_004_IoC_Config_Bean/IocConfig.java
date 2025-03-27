package com.osmanbatuhan._004_IoC_Config_Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.osmanbatuhan._004_IoC_Config_Bean")

public class IocConfig {
    @Bean
    public ICustomerDal database() {
        return new MsSqlCustomerDal();
        //return new MysqlCustomerDal();
        //Artık istediğimizi çağırıp kullanabiliriz.
    }

}



/// Eski _003_ halini kıyas için buraya gömeceğim
/*
@Configuration /// Bir config dosyası olabilmesi için gerekli olan anatasyon.
///"applicationContextSpringDemoIoC.xml" yazmaya gerek kalmadan onu bu şekilde config ile tutabiliriz.

@ComponentScan("com.osmanbatuhan._003_IoC_Config")/// Bu kısım ise "applicationContextSpringDemoIoC.xml" içerisindeki 'component-scan' yerine kullanılır.
/// Biz bundan sonra 'XML'i değil Anatasyon bazlı olan bu class'ı kullanacağız.

public class IocConfig {
}
* */