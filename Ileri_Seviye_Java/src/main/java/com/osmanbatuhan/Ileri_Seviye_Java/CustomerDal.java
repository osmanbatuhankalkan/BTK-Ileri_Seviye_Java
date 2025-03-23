package com.osmanbatuhan.Ileri_Seviye_Java;

public class CustomerDal implements ICustomerDal {
    private String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void add(){
        System.out.println("Connection string: " + this.connectionString);
        System.out.println("Oracle Veri Tabanı Bağlandı");
    }
}
