import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LeczniceComponent } from './lecznice.component';
import {LeczniceListComponent} from "./lecznice-list/lecznice-list.component";
import {LeczniceCreateComponent} from "./lecznice-create/lecznice-create.component";
import {LeczniceDetailComponent} from "./lecznice-detail/lecznice-detail.component";

const routes: Routes = [
  {
    path: '',
    component: LeczniceComponent,
    children: [
      { path: '', component: LeczniceListComponent },
      { path: 'create', component: LeczniceCreateComponent },
      { path: ':id', component: LeczniceDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LeczniceRoutingModule { }
