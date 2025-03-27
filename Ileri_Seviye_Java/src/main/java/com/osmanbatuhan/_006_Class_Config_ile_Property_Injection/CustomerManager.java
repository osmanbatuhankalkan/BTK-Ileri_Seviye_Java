package com.osmanbatuhan._006_Class_Config_ile_Property_Injection;

import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerDal;
import com.osmanbatuhan._006_Class_Config_ile_Property_Injection.ICustomerService;

public class CustomerManager implements ICustomerService {//interface ile beslemeliyiz.
    /// Önemli Not:Eğer bir class herhangi bir implementasyon yada extends almazsa ileride bağımlılık problemlerine yaklanacağının işaretidir.
    /// çıplak class kalmamalı.
    private ICustomerDal customerDal;

    /// bizim ICustomerService'de bir add() operasyonumuz vardı.Bu iş kodları içinde CustomerManager onu kullanıyor.
    /// İş kodu CustomerManager bir tane ekleme yapacak, önce iş kuralları yazıyoruz.Sonra (DAL)'ı çağıracak.
    /// CustomerManager'da bir Injectiona ihtiyaç duyuyor(Constructorundaki ICustomerDal).
    /// Bana diyor bir ICustomerDal ver yani seni implemente eden Dal sınıflarını getir verr diyoor.(MysqlCustomerDal,MsSqlCustomerDal).
    ///*** Bağımlı olmamak için ICustomerDal üzerinden istiyor.

    /// Constructor Injection
    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }

    @Override
    public void add(){
        //iş kuralları
        customerDal.add();
    }
}
