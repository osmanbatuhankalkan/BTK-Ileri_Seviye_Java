package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

public interface ICustomerDal {//Artık IOC kullanacağımız için, yani class içinde class çağırmamak için
    //Daha önce CustomerDal sınıfımızda olan, operasyonu biz artık bir INTERFACE üzerinden yöneteceğiz.
    void add();
}
