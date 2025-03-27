package com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi;

import com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi.ICustomerDal;
import com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi.MsSqlCustomerDal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.osmanbatuhan._005_Bagli_Classlarin_Cozumlenmesi")
public class IocConfig {
    @Bean
    public ICustomerDal database() {
        return new MsSqlCustomerDal();
        //return new MysqlCustomerDal();
        //Artık istediğimizi çağırıp kullanabiliriz.
    }
    @Bean
    public ICustomerService service() {
        return new CustomerManager(database());///Burada database() üzerinden çağırarak BAĞIMLI olmaktan kurtardık.
        ///yoksa buraya new MySqlCustomerDal, new MsSqlCustomerDal'da yazılabilir.

        /// ICustomerDal zaten bunların atası oldup, bunlar(Dal sınıfları) implemente ettiği için bunları bünyesinde referanslarını tutuyor.
        //database() üzerinden burada çağırarak, esneklik sağlıyoruz.Tek bir yerden yönetilmesini sağlıyoruz.
    }

}