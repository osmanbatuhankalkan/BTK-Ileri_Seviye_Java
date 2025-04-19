package com.javacourse.springBootDemo.restApi;

import com.javacourse.springBootDemo.Business.ICityService;
import com.javacourse.springBootDemo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /// **** Burası çok önemli biz şehirleri getirmek, listelemek için GETMAPPİNG kullandık.
    /// GET işlemi Şudur: Ben, Bu veri tabanı üzerinde değişiklik yapmak istemiyorum, Bana DATA ver demek. Buna Get operasyonu denir.
    /// FAKAT 'ekleme' , 'güncelleme' ve 'silme' operasyonlarında bu 'POST' olur.
    @PostMapping("/add")
    public void add(@RequestBody City city) {
        cityService.add(city);
    }
    @PostMapping("/update")
    public void update(@RequestBody City city) {
        cityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city) {
        cityService.delete(city);
    }
    @GetMapping("/cities/{id}")//dinamik bir şekilde id alıyoruz.
    // Bunun içinde bir anatasyon var Bu anatasyonun ismi @PathVariable ordan id yi oku diyoruz.
    public City getById(@PathVariable int id) {
        return cityService.getById(id);
    }
}
