import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LudzieComponent } from './ludzie.component';
import {LudzieListComponent} from "./ludzie-list/ludzie-list.component";
import {LudzieCreateComponent} from "./ludzie-create/ludzie-create.component";
import {LudzieDetailComponent} from "./ludzie-detail/ludzie-detail.component";

const routes: Routes = [
  {
    path: '',
    component: LudzieComponent,
    children: [
      { path: '', component: LudzieListComponent },
      { path: 'create', component: LudzieCreateComponent },
      { path: ':id', component: LudzieDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LudzieRoutingModule { }
