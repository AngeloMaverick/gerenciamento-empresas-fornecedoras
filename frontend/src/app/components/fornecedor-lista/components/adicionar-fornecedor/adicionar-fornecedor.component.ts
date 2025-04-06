import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Modal } from 'bootstrap';

@Component({
  standalone: true,
  selector: 'app-adicionar-fornecedor',
  templateUrl: './adicionar-fornecedor.component.html',
  styleUrl: './adicionar-fornecedor.component.scss',
  imports: [CommonModule, FormsModule],
})
export class AdicionarFornecedorComponent {
  modal!: Modal;

  abrirModal(modalElement: HTMLElement) {
    this.modal = new Modal(modalElement);
    this.modal.show();
  }
}
