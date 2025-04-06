import { Routes } from '@angular/router';
import { EmpresaListaComponent } from './components/empresa-lista/empresa-lista.component';
import { FornecedorListaComponent } from './components/fornecedor-lista/fornecedor-lista.component';

export const routes: Routes = [
  {
    path: '',
    component: EmpresaListaComponent,
  },
  {
    path: 'fornecedores',
    component: FornecedorListaComponent,
  },
];
