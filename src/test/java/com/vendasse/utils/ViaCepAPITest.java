package com.vendasse.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class) // Habilita o Mockito no JUnit 5
public class ViaCepAPITest {

    @Mock
    private ViaCepAPI viaCepAPI; // Cria o mock da sua dependência

    @Test
    void shouldReturnRight(){

        // Executa (When)
        String cidade = viaCepAPI.getCityByCep("55270000");

        // Verifica (Then)
        assertEquals("Venturosa", cidade);

    }
}