import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PracownicyComponent } from './pracownicy.component';
import {LudzieComponent} from "../ludzie/ludzie.component";
import {LudzieListComponent} from "../ludzie/ludzie-list/ludzie-list.component";
import {LudzieCreateComponent} from "../ludzie/ludzie-create/ludzie-create.component";
import {LudzieDetailComponent} from "../ludzie/ludzie-detail/ludzie-detail.component";
import {PracownicyListComponent} from "./pracownicy-list/pracownicy-list.component";
import {PracownicyCreateComponent} from "./pracownicy-create/pracownicy-create.component";
import {PracownicyDetailComponent} from "./pracownicy-detail/pracownicy-detail.component";

const routes: Routes = [
  {
    path: '',
    component: PracownicyComponent,
    children: [
      { path: '', component: PracownicyListComponent },
      { path: 'create', component: PracownicyCreateComponent },
      { path: ':id', component: PracownicyDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PracownicyRoutingModule { }
