package com.web.simpleWebApp.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;


@Component
@Entity
public class Products {

    private String prodName;
    @Id
    private int prodId;
    private int prodPrice;

    public Products(String prodName, int prodId, int prodPrice) {
        this.prodName = prodName;
        this.prodId = prodId;
        this.prodPrice = prodPrice;
    }

    public Products() {

    }


    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }


}
