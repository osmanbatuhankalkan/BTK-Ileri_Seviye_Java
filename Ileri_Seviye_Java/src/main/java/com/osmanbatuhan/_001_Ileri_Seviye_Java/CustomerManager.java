package com.osmanbatuhan._001_Ileri_Seviye_Java;

public class CustomerManager implements ICustomerService{//interface ile beslemeliyiz.
    /// Önemli Not:Eğer bir class herhangi bir implementasyon yada extends almazsa ileride bağımlılık problemlerine yaklanacağının işaretidir.
    /// çıplak class kalmamalı.
    private ICustomerDal customerDal;

    /// Constructor Injection
    //public CustomerManager(ICustomerDal customerDal) {
      //  this.customerDal = customerDal;
    //}

    /// setter Injection
    public void setCustomerDal(ICustomerDal customerDal) {
        this.customerDal=customerDal;
    }
    public void add(){
        //iş kuralları
        customerDal.add();
    }
}
