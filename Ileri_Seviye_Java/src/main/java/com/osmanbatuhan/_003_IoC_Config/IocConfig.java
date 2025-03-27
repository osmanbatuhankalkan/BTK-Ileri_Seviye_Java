package com.osmanbatuhan._003_IoC_Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration /// Bir config dosyası olabilmesi için gerekli olan anatasyon.
///"applicationContextSpringDemoIoC.xml" yazmaya gerek kalmadan onu bu şekilde config ile tutabiliriz.

@ComponentScan("com.osmanbatuhan._003_IoC_Config")/// Bu kısım ise "applicationContextSpringDemoIoC.xml" içerisindeki 'component-scan' yerine kullanılır.
/// Biz bundan sonra 'XML'i değil Anatasyon bazlı olan bu class'ı kullanacağız.

public class IocConfig {
}
