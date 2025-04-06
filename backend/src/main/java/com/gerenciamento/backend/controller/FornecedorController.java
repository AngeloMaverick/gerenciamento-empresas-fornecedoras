package com.gerenciamento.backend.controller;

import com.gerenciamento.backend.model.Empresa;
import com.gerenciamento.backend.model.Fornecedor;
import com.gerenciamento.backend.repository.EmpresaRepository;
import com.gerenciamento.backend.repository.FornecedorRepository;
import com.gerenciamento.backend.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping("/empresa/{empresaId}")
    public Fornecedor criar(@PathVariable Long empresaId, @RequestBody Fornecedor fornecedor) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        return fornecedorService.salvar(fornecedor, empresa);
    }

    @GetMapping
    public Page<Fornecedor> listarComFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String documento,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nome").ascending());

        if ((nome == null || nome.isBlank()) && (documento == null || documento.isBlank())) {
            return fornecedorRepository.findAll(pageable);
        }

        return fornecedorRepository.findAll((root, query, cb) -> {
            var predicates = cb.conjunction();

            if (nome != null && !nome.isBlank()) {
                predicates.getExpressions().add(cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%"));
            }

            if (documento != null && !documento.isBlank()) {
                predicates.getExpressions().add(cb.equal(root.get("documento"), documento));
            }

            return predicates;
        }, pageable);
    }

    @GetMapping("/{id}")
    public Fornecedor buscarPorId(@PathVariable Long id) {
        return fornecedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        fornecedorRepository.deleteById(id);
    }
}
