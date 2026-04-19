package com.vendasse.dtos.product;

import com.vendasse.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ProductRequestDTO {

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private int amount;


    @NotBlank
    private boolean active;
    @NotBlank
    private String description;
    @NotBlank
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotBlank
    private String cep;

    public  String getCep() {
        return cep;
    }

    public void setCep( String cep) {
        this.cep = cep;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    @NotBlank
    public boolean isActive() {
        return active;
    }

    public @NotBlank LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NotBlank LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setActive(@NotBlank boolean active) {
        this.active = active;
    }

    @NotBlank
    public int getAmount() {
        return amount;
    }

    @NotBlank
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotBlank BigDecimal price) {
        this.price = price;
    }

    public void setAmount(@NotBlank int amount) {
        this.amount = amount;
    }

    public @NotBlank(message = "O nome do produto é obrigatório.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "O nome do produto é obrigatório.") String name) {
        this.name = name;
    }



}
