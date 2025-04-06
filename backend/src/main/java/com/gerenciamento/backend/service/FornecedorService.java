package com.gerenciamento.backend.service;

import com.gerenciamento.backend.dto.CepResponse;
import com.gerenciamento.backend.enums.TipoFornecedor;
import com.gerenciamento.backend.model.*;
import com.gerenciamento.backend.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CepService cepService;

    @Transactional
    public Fornecedor salvar(Fornecedor fornecedor, Empresa empresa) {        
        if (fornecedorRepository.findByDocumento(fornecedor.getDocumento()).isPresent()) {
            throw new IllegalArgumentException("Documento já cadastrado.");
        }
                
        CepResponse endereco = cepService.getEndereco(empresa.getCep());
       
        if (fornecedor.getTipo() == TipoFornecedor.PESSOA_FISICA) {
            String parana = "PR";

            if (fornecedor.getDataNascimento() == null) {
                throw new IllegalArgumentException("Data de nascimento obrigatória para PF.");
            }

            int idade = Period.between(fornecedor.getDataNascimento(), LocalDate.now()).getYears();
            if (parana.equals(endereco.getState()) && idade < 18) {
                throw new IllegalArgumentException("Fornecedor menor de idade não permitido para empresas do Paraná.");
            }

            if (fornecedor.getRg() == null || fornecedor.getRg().isEmpty()) {
                throw new IllegalArgumentException("RG é obrigatório para Pessoa Física.");
            }
        }

        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deletar(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
