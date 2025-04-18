package com.javacourse.springBootDemo.restApi;

import com.javacourse.springBootDemo.Business.ICityService;
import com.javacourse.springBootDemo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")//Bu operasyondaki her şey api ile başlayacak dedik.
//Bizim buraya bağımlılığımız nedir. Dersek Business bizim bağımlılığımızdir.
public class CityController {
    private ICityService cityService;

    @Autowired //Hızlı Enjection yapıyoruz.
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/cities")
    public List<City> get() {
        return cityService.getAll();
    }
}
