package com.osmanbatuhan._003_IoC_Config;

import org.springframework.stereotype.Component;
//Bu 'Dal' classlarına herhangi bir müdahalede bulunmadık.
@Component("database")
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
