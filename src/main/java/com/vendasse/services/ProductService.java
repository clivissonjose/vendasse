package com.vendasse.services;

import com.vendasse.models.Product;
import com.vendasse.repositories.ProductRepository;
import com.vendasse.utils.ViaCepAPI;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProductService {

    ProductRepository productRepository;
    private final ViaCepAPI viaCepApi;

    ProductService(ProductRepository productRepository, ViaCepAPI viaCepAPI){

        this.productRepository = productRepository;
        this.viaCepApi = viaCepAPI;

    }


    public Product create(Product product){

        String cep = product.getCep();
        String cidade = viaCepApi.getCityByCep(cep);
        product.setCity(cidade);

        return this.productRepository.save(product);

    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }

    public  Product updatePrice(Long id, BigDecimal newPrice){

        Product product = this.productRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException());

        product.setPrice(newPrice);

        // Atualizar updateAt
        product.setUpdatedAt(LocalDateTime.now());

        return this.productRepository.save(product);

    }

    public List<Product> findAll(){

        return this.productRepository.findAll();

    }



}
