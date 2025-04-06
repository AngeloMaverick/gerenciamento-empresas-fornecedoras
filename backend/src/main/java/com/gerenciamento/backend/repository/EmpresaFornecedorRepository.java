package com.gerenciamento.backend.repository;

import com.gerenciamento.backend.model.EmpresaFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaFornecedorRepository extends JpaRepository<EmpresaFornecedor, Long> {
    
}
