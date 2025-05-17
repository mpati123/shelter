import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GatunekComponent } from './gatunek.component';
import {GatunekListComponent} from "./gatunek-list/gatunek-list.component";
import {GatunekCreateComponent} from "./gatunek-create/gatunek-create.component";
import {GatunekDetailComponent} from "./gatunek-detail/gatunek-detail.component";

const routes: Routes = [
  {
    path: '',
    component: GatunekComponent,
    children: [
      { path: '', component: GatunekListComponent },
      { path: 'create', component: GatunekCreateComponent },
      { path: ':id', component: GatunekDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GatunekRoutingModule { }
