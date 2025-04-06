package com.gerenciamento.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CepResponse {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service; 
}
