package com.gerenciamento.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.gerenciamento.backend.dto.CepResponse;

@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public CepResponse getEndereco(String cep) {
        String url = UriComponentsBuilder.fromUriString("https://brasilapi.com.br/api/cep/v1/" + cep).toUriString();

        try {
            CepResponse response = restTemplate.getForObject(url, CepResponse.class);
            return response != null ? response : null;
        } catch (Exception e) {
            throw new IllegalArgumentException("CEP inválido ou não encontrado");
        }
    }    
}
