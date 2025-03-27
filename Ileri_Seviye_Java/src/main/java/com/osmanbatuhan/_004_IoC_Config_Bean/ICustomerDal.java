package com.osmanbatuhan._004_IoC_Config_Bean;

public interface ICustomerDal {//Artık IOC kullanacağımız için, yani class içinde class çağırmamak için
    //Daha önce CustomerDal sınıfımızda olan, operasyonu biz artık bir INTERFACE üzerinden yöneteceğiz.
    void add();
}
