package com.vendasse.utils;

import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class ViaCepAPI {

    private final HttpClient client = HttpClient.newHttpClient();

    private static final Pattern ERRO_PATTERN = Pattern.compile("\"erro\"\\s*:\\s*true");
    private static final Pattern LOCALIDADE_PATTERN = Pattern.compile("\"localidade\"\\s*:\\s*\"([^\"]*)\"");

    public String getCityByCep(String cep) {
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode ser vazio");
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            // Verifica se o CEP é inválido
            Matcher erroMatcher = ERRO_PATTERN.matcher(body);
            if (erroMatcher.find()) {
                throw new RuntimeException("CEP inválido");
            }

            Matcher localidadeMatcher = LOCALIDADE_PATTERN.matcher(body);
            if (localidadeMatcher.find()) {
                return localidadeMatcher.group(1);
            }

            throw new RuntimeException("Cidade não encontrada na resposta do ViaCEP");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar ViaCEP", e);
        }
    }

}