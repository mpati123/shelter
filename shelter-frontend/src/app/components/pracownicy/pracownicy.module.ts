import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PracownicyRoutingModule } from './pracownicy-routing.module';
import { PracownicyComponent } from './pracownicy.component';
import { PracownicyListComponent } from './pracownicy-list/pracownicy-list.component';
import { PracownicyDetailComponent } from './pracownicy-detail/pracownicy-detail.component';
import { PracownicyCreateComponent } from './pracownicy-create/pracownicy-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    PracownicyComponent,
    PracownicyListComponent,
    PracownicyDetailComponent,
    PracownicyCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    PracownicyRoutingModule
  ]
})
export class PracownicyModule { }
