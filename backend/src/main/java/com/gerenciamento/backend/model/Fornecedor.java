package com.gerenciamento.backend.model;

import jakarta.persistence.*;
//import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import com.gerenciamento.backend.enums.TipoFornecedor;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Fornecedor {

    //@Valid
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TipoFornecedor tipo;

    @NotBlank(message = "O CPF ou CNPJ é obrigatório")
    @Column(unique = true, nullable = false, length = 18)
    private String documento;

    @NotBlank(message = "O Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O E-mail é obrigatório")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve conter 8 dígitos numéricos")
    @Column(nullable = false)
    private String cep;

    private String rg;

    private LocalDate dataNascimento;
}

