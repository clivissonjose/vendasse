package com.vendasse.dtos.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class UpdateProductPriceDTO {

    @NotNull
    @Positive
    private BigDecimal newPrice;

    public @NotNull @Positive BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(@NotNull @Positive BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

}
