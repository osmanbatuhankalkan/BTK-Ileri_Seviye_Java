package com.osmanbatuhan.SpringDemoIOCAnnotation;

public interface ICustomerDal {//Artık IOC kullanacağımız için, yani class içinde class çağırmamak için
    //Daha önce CustomerDal sınıfımızda olan, operasyonu biz artık bir INTERFACE üzerinden yöneteceğiz.
    void add();
}
