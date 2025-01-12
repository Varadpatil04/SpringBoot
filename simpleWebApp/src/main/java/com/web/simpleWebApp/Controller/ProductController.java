package com.web.simpleWebApp.Controller;

import com.web.simpleWebApp.Model.Products;
import com.web.simpleWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Products> getProduct(){
        return service.getProducts();
    }

    @RequestMapping("/products/{prodId}")
    public Products getProductByID(@PathVariable int prodId){
        return service.getProductByID(prodId);
    }

//    @RequestMapping("/products/{prodName}")
//    public Products getProductbyName(@PathVariable String prodName){
//        return service.getProductbyName(prodName);
//    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Products prod){
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateData(@RequestBody Products prod){
        service.updateData(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteData(@PathVariable int prodId){
        service.deleteData(prodId);
    }

}
