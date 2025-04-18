package com.javacourse.springBootDemo.Business;

import com.javacourse.springBootDemo.DataAccess.ICityDal;
import com.javacourse.springBootDemo.Entities.City;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//ICityService içerisindeki imzaları, burada method olarak kullanarak işlerimizi yaparız.
//DataAccess ve Business'ımız var. Business şimdi DataAceesten hizmet alacak, dolayısıyla DA ile iletişim için hiç bir zaman, somut classlarla iletişim kurdurmayacağız.
//Onun yerine bizim ICityDal'ımız var.
//Bunu Depency Enjection ile hallediyor olacağız.

@Service
public class CityManager implements ICityService {

    private ICityDal cityDal;
    //Buradaki ICityDal'ın çözümlenmesi gerekiyor.Onun içinde burada da @Autowired anatasyonunu kullanacağız.
    //Sen git bak ICityDal'a uygun bir şey varsa, onu ver der.
    @Autowired
    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        return this.cityDal.getAll(); //şuan biz hibernate bağımlı değiliz. Biz sadece interface'i verdik.
        // @Autowired, şuan haızrda hibernate olduğu için bu çözümlemeyi bizim için yapıyor.

    }

    @Override
    @Transactional
    public void add(City city) {

    }

    @Override
    @Transactional
    public void update(City city) {

    }

    @Override
    @Transactional
    public void delete(City city) {

    }
}
