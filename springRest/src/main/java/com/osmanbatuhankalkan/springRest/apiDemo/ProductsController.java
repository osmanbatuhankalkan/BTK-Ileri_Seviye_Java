package com.osmanbatuhankalkan.springRest.apiDemo;
//Restfull API olabilmesi için bunun bir anatasyonla süslenmesi gerekiyor. @RestController

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/") //Burada hiç bir şey yapmasakta uygulamanın anasayfasında.
    // get olarak sunduğumuz. 'Laptop' listelenecek, gözükecek.
    public String get(){
        return "Laptop";
    }
    ///*********************************************************
    @GetMapping("/products") //Burada localhost:8080/products a giderek uygulamanın,
    // get2 olarak sunduğumuz. 'Laptop2' listelenecek, gözükecek.
    public String get2(){
        return "Laptop2";
    }
}
