package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

//import org.springframework.stereotype.Component;

import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerDal;
import org.springframework.beans.factory.annotation.Value;

//@Component("database")
//ICustomerDal'ı implemente ettikleri için, ICustomerDal bunların referansını tutabildiği için bunların yerine geçebilir.
//O yüzden burada birden fazla component bağlanacaksa bunu kullanmaya gerek yoktur.'IocConfig.java'da bunu yönetiyoruz.
public class MysqlCustomerDal implements ICustomerDal {

    /// Buraya gelip sen bu anatasyon değerini oku diyeceğiz class içerisinde. Önceden applicatıonContexlerde XML uzantısında yapıyorrduk bu işlemi. values.properties valuesi okunacak.
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
        System.out.println("MySql Veri Tabanına bağlandı.");
    }
}
