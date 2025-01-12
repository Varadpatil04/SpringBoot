package com.web.simpleWebApp.Service;

import com.web.simpleWebApp.Model.Products;
import com.web.simpleWebApp.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Products> product = new ArrayList<>( Arrays.asList(
//            new Products("Iphone",111,50000),
//            new Products("Laptop",112,40000),
//            new Products("Speaker",113,1500),
//            new Products("Tablet", 114, 25000),
//            new Products("Smartwatch", 115, 12000),
//            new Products("Headphones", 116, 5000),
//            new Products("Camera", 117, 35000),
//            new Products("Smart TV", 118, 60000),
//            new Products("Gaming Console", 119, 30000),
//            new Products("Printer", 120, 10000)
//    ));

   public List<Products> getProducts(){
       return repo.findAll();
   }

    public Products getProductByID(int prodId) {
//       return product.stream()
//               .filter(p -> p.getProdId() == prodId )
//               .findFirst().orElse(new Products("No-Product-Find",000,000));
        return repo.findById(prodId).orElse(new Products());
   }

//    public Products getProductbyName(String prodName) {
////       return product.stream()
////               .filter(p -> p.getProdName().equals(prodName) )
////               .findFirst().orElse(new Products("No-Product-Find",000,000));
//   }

    public void addProduct(Products prod){
         repo.save(prod);
    }

    public void updateData(Products prod){
//       product.stream().filter(p-> p.getProdId() == prod.getProdId()).findFirst().ifPresent(ep -> {
//           ep.setProdName(prod.getProdName());
//           ep.setProdPrice(prod.getProdPrice());
//       });
        repo.save(prod);
    }

    public void deleteData(int prodId) {
//       product.removeIf(p -> p.getProdId() == prodId);
        repo.deleteById(prodId);
   }
}
