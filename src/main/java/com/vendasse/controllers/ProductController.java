package com.vendasse.controllers;

import com.vendasse.dtos.product.ProductRequestDTO;
import com.vendasse.dtos.product.ProductResponseDTO;
import com.vendasse.dtos.product.UpdateProductPriceDTO;
import com.vendasse.mappers.ProductMapper;
import com.vendasse.models.Product;
import com.vendasse.services.ProductService;
import com.vendasse.utils.ViaCepAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;


    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO dto){


        Product product = ProductMapper.toEntity(dto);
        Product response = productService.create(product);

        ProductResponseDTO responseDTO = ProductMapper.toDTO(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteById(@PathVariable Long id ){

        productService.delete(id);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/price/{id}")
    public ResponseEntity<ProductResponseDTO> updatePrice(@RequestBody UpdateProductPriceDTO dto, @PathVariable Long id){

        Product product = this.productService.updatePrice(id, dto.getNewPrice());

        ProductResponseDTO responseDTO = ProductMapper.toDTO(product);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);

    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>>  findAll(){

        List<Product>  products = this.productService.findAll();

        List<ProductResponseDTO> response = products.stream()
                .map(ProductMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);

    }


}
