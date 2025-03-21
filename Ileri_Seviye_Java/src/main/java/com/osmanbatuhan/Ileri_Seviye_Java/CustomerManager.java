package com.osmanbatuhan.Ileri_Seviye_Java;

public class CustomerManager {
    private final ICustomerDal customerDal;

    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    public void add(){
        //iş kuralları
        customerDal.add();
    }
}
