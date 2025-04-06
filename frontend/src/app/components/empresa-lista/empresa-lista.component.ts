import { Component, OnInit } from '@angular/core';
import { EmpresaService } from '../../services/empresa.service';
import { Empresa } from '../../models/empresa.model';
import { CommonModule } from '@angular/common';
import { AdicionarEmpresaComponent } from './components/adicionar-empresa/adicionar-empresa.component';

@Component({
  standalone: true,
  selector: 'app-empresa-lista',
  templateUrl: './empresa-lista.component.html',
  styleUrls: ['./empresa-lista.component.scss'],
  imports: [CommonModule, AdicionarEmpresaComponent],
})
export class EmpresaListaComponent implements OnInit {
  empresas: Empresa[] = [];

  constructor(private empresaService: EmpresaService) {}

  ngOnInit(): void {
    this.empresaService.listar().subscribe({
      next: (dados) => (this.empresas = dados),
      error: (erro) => console.error('Erro ao buscar empresas', erro),
    });
  }
}
