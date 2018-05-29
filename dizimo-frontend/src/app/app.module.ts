import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';

import { AppRoutingModule } from './/app.routing';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SideNavComponent } from './side-nav/side-nav.component';
import { DizimistaComponent } from './componentes/dizimista/dizimista.component';
import { DizimistaService } from './services/dizimista/dizimista.service';
import { HttpModule } from '@angular/http';
import { DizimistaEditComponent } from './componentes/dizimista/dizimista-edit/dizimista-edit.component';
import { MatDatepickerModule, MatNativeDateModule } from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    SideNavComponent,
    DizimistaComponent,
    DizimistaEditComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule
  ],
  providers: [DizimistaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
