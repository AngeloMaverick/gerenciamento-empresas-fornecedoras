package com.gerenciamento.backend.model;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "CNPJ é obrigatório")
    @CNPJ(message = "CNPJ inválido")        
    @Column(unique = true, length = 18, nullable = false)
    private String cnpj;

    @NotBlank(message = "Nome Fantasia é obrigatório")
    @Size(max = 100, message = "Nome Fantasia deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nomeFantasia;
    
    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{5}\\-\\d{3}", message = "Formato de CEP inválido")
    @Column(nullable = false, length = 10)
    private String cep;
}