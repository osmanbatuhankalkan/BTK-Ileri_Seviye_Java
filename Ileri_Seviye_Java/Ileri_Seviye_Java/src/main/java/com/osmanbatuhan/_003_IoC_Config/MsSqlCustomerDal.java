package com.osmanbatuhan._003_IoC_Config;


//@Component("database")
public class MsSqlCustomerDal implements ICustomerDal {
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
