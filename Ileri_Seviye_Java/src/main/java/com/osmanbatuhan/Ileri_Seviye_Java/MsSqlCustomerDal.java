package com.osmanbatuhan.Ileri_Seviye_Java;

public class MsSqlCustomerDal implements ICustomerDal {
    @Override
    public void add() {
        System.out.println("Ms SQL veri tabanına eklendi");
    }
}
