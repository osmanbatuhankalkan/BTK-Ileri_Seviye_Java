package com.osmanbatuhan.Ileri_Seviye_Java;

public class Main {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new MysqlCustomerDal());
        customerManager.add();
    }
}
