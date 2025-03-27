package com.osmanbatuhan._004_IoC_Config_Bean;

//import org.springframework.stereotype.Component;

//@Component("database")
//ICustomerDal'ı implemente ettikleri için, ICustomerDal bunların referansını tutabildiği için bunların yerine geçebilir.
//O yüzden burada birden fazla component bağlanacaksa bunu kullanmaya gerek yoktur.'IocConfig.java'da bunu yönetiyoruz.
public class MysqlCustomerDal implements ICustomerDal {
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
