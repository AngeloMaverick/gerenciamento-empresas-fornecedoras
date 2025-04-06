import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Modal } from 'bootstrap';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { validarCnpj } from '../../../../utils/validarCnpj';

@Component({
  selector: 'app-adicionar-empresa',
  standalone: true,
  imports: [CommonModule, FormsModule, NgxMaskDirective],
  templateUrl: './adicionar-empresa.component.html',
  styleUrls: ['./adicionar-empresa.component.scss'],
  providers: [provideNgxMask()],
})
export class AdicionarEmpresaComponent {
  cnpj = '';
  nomeFantasia = '';
  cep = '';
  modal!: Modal;
  cnpjInvalido = false;

  onCnpjChange() {
    this.cnpjInvalido = false;
  }

  abrirModal(modalElement: HTMLElement) {
    this.modal = new Modal(modalElement);
    this.modal.show();
  }

  salvar() {
    this.cnpjInvalido = !validarCnpj(this.cnpj);
    console.log('cnpjInvalido? ', this.cnpjInvalido);
    console.log('cnpj: ', this.cnpj);
    //this.modal.hide();
  }
}
