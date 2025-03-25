package com.osmanbatuhan.SpringDemoIOCAnnotation;

import org.springframework.stereotype.Component;

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
