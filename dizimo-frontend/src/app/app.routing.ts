import { DizimistaEditComponent } from './componentes/dizimista/dizimista-edit/dizimista-edit.component';
import { DizimistaComponent } from './componentes/dizimista/dizimista.component';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'dizimista', component: DizimistaComponent},
  {path: 'dizimista/add', component: DizimistaEditComponent},
  {path: 'dizimista/edit/:id', component: DizimistaEditComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
  
export class AppRoutingModule {}
