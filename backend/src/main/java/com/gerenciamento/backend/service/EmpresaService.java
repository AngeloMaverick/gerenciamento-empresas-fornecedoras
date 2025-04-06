package com.gerenciamento.backend.service;

import com.gerenciamento.backend.model.Empresa;
import com.gerenciamento.backend.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private CepService cepService;

    public Empresa salvar(Empresa empresa) {
        if (empresaRepository.existsByCnpj(empresa.getCnpj())) {
            throw new IllegalArgumentException("CNPJ já em uso");
        }

        cepService.getEndereco(empresa.getCep());
        
        return empresaRepository.save(empresa);
    }

    public List<Empresa> listarTodos() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public void deletar(Long id) {
        empresaRepository.deleteById(id);
    }
}
