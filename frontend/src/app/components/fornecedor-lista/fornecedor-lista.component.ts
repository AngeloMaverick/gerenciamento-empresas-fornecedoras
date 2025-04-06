import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Fornecedor } from '../../models/fornecedor.model';
import { FornecedorService } from '../../services/fornecedor.service';
import { AdicionarFornecedorComponent } from './components/adicionar-fornecedor/adicionar-fornecedor.component';

@Component({
  standalone: true,
  selector: 'app-fornecedor-lista',
  templateUrl: './fornecedor-lista.component.html',
  styleUrls: ['./fornecedor-lista.component.scss'],
  imports: [CommonModule, AdicionarFornecedorComponent],
})
export class FornecedorListaComponent implements OnInit {
  fornecedores: Fornecedor[] = [];

  constructor(private fornecedorService: FornecedorService) {}

  ngOnInit(): void {
    this.fornecedorService.listar().subscribe({
      next: (dados) => (this.fornecedores = dados.content),
      error: (erro) => console.error('Erro ao buscar fornecedores', erro),
    });
  }
}
