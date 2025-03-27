package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.CustomerManager;
import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerDal;
import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerService;
import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.MsSqlCustomerDal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.osmanbatuhan._006_Class_Config_ile_Property_Injection")

@PropertySource("classpath:values.properties")/// önceden bu işlemi manuel olarak XMl dosyamızda yapıyorduk.
///applicatonContextlerde bu şekilde classlardan values.propertiese erişiyoruz.
public class IocConfig {
    @Bean
    public ICustomerDal database() {
        return new MsSqlCustomerDal();

    }
    @Bean
    public ICustomerService service() {
        return new CustomerManager(database());


    }

}