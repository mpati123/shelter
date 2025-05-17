import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ZbiorkiComponent } from './zbiorki.component';
import {LudzieComponent} from "../ludzie/ludzie.component";
import {LudzieListComponent} from "../ludzie/ludzie-list/ludzie-list.component";
import {LudzieCreateComponent} from "../ludzie/ludzie-create/ludzie-create.component";
import {LudzieDetailComponent} from "../ludzie/ludzie-detail/ludzie-detail.component";
import {ZbiorkiListComponent} from "./zbiorki-list/zbiorki-list.component";
import {ZbiorkiCreateComponent} from "./zbiorki-create/zbiorki-create.component";
import {ZbiorkiDetailComponent} from "./zbiorki-detail/zbiorki-detail.component";

const routes: Routes = [
  {
    path: '',
    component: ZbiorkiComponent,
    children: [
      { path: '', component: ZbiorkiListComponent },
      { path: 'create', component: ZbiorkiCreateComponent },
      { path: ':id', component: ZbiorkiDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ZbiorkiRoutingModule { }
