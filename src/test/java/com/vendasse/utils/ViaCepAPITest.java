package com.vendasse.utils;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class) // Habilita o Mockito no JUnit 5
public class ViaCepAPITest {

    private ViaCepAPI viaCepAPI = new ViaCepAPI();

    @Test
    void shouldReturnCityFromCep(){

        String cidade = viaCepAPI.getCityByCep("55270000");

        assertEquals("Venturosa", cidade);
    }
}