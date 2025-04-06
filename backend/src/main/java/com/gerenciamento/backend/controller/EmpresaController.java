package com.gerenciamento.backend.controller;

import com.gerenciamento.backend.model.Empresa;
import com.gerenciamento.backend.service.EmpresaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa criar(@RequestBody @Valid Empresa empresa) {
        return empresaService.salvar(empresa);
    }

    @GetMapping
    public List<Empresa> listar() {
        return empresaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable Long id) {
        return empresaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaService.deletar(id);
    }
}
