package com.gerenciamento.backend.service;

import com.gerenciamento.backend.model.Empresa;
import com.gerenciamento.backend.model.EmpresaFornecedor;
import com.gerenciamento.backend.model.Fornecedor;
import com.gerenciamento.backend.repository.EmpresaFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaFornecedorService {

    @Autowired
    private EmpresaFornecedorRepository empresaFornecedorRepository;

    public EmpresaFornecedor vincular(Empresa empresa, Fornecedor fornecedor) {
        EmpresaFornecedor ef = new EmpresaFornecedor();
        ef.setEmpresa(empresa);
        ef.setFornecedor(fornecedor);
        return empresaFornecedorRepository.save(ef);
    }
}
