package com.vendasse.dtos.product;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ProductResponseDTO {


    private String name;

    private BigDecimal price;

    private int amount;


    private String city;


    public  String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal
    getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
