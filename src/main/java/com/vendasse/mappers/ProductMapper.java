package com.vendasse.mappers;

import com.vendasse.dtos.product.ProductRequestDTO;
import com.vendasse.dtos.product.ProductResponseDTO;
import com.vendasse.models.Product;
import com.vendasse.utils.ViaCepAPI;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ProductMapper {


    public static Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();

        product.setActive(true);
        product.setCreatedAt(LocalDateTime.now());

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setCep(dto.getCep());

        return product;
    }

    public static ProductResponseDTO toDTO(Product product){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setAmount(product.getAmount());
        productResponseDTO.setCity(product.getCity());


        return productResponseDTO;

    }
}
