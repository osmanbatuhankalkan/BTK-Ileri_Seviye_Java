package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerDal;
import org.springframework.beans.factory.annotation.Value;

//@Component("database")
//ICustomerDal'ı implemente ettikleri için, ICustomerDal bunların referansını tutabildiği için bunların yerine geçebilir.
//O yüzden burada birden fazla component bağlanacaksa bunu kullanmaya gerek yoktur.'IocConfig.java'da bunu yönetiyoruz.
public class MsSqlCustomerDal implements ICustomerDal {
    @Value("${local.email2}")
    private String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void add() {
        System.out.println("Connection String: " + this.connectionString);
        System.out.println("Ms SQL veri tabanına eklendi");
    }
}
