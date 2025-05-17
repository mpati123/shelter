import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ZwierzetaComponent } from './zwierzeta.component';
import {LudzieComponent} from "../ludzie/ludzie.component";
import {LudzieListComponent} from "../ludzie/ludzie-list/ludzie-list.component";
import {LudzieCreateComponent} from "../ludzie/ludzie-create/ludzie-create.component";
import {LudzieDetailComponent} from "../ludzie/ludzie-detail/ludzie-detail.component";
import {ZwierzetaListComponent} from "./zwierzeta-list/zwierzeta-list.component";
import {ZwierzetaCreateComponent} from "./zwierzeta-create/zwierzeta-create.component";
import {ZwierzetaDetailComponent} from "./zwierzeta-detail/zwierzeta-detail.component";

const routes: Routes = [
  {
    path: '',
    component: ZwierzetaComponent,
    children: [
      { path: '', component: ZwierzetaListComponent },
      { path: 'create', component: ZwierzetaCreateComponent },
      { path: ':id', component: ZwierzetaDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ZwierzetaRoutingModule { }
