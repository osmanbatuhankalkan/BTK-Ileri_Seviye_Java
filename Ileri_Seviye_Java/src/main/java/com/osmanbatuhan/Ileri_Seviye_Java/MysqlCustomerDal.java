package com.osmanbatuhan.Ileri_Seviye_Java;

public class MysqlCustomerDal implements ICustomerDal {
    @Override
    public void add() {
        System.out.println("MySql Veri Tabanına bağlandı.");
    }
}
