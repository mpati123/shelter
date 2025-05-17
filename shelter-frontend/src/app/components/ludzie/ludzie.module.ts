import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LudzieRoutingModule } from './ludzie-routing.module';
import { LudzieComponent } from './ludzie.component';
import { LudzieListComponent } from './ludzie-list/ludzie-list.component';
import { LudzieDetailComponent } from './ludzie-detail/ludzie-detail.component';
import { LudzieCreateComponent } from './ludzie-create/ludzie-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    LudzieComponent,
    LudzieListComponent,
    LudzieDetailComponent,
    LudzieCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    LudzieRoutingModule
  ]
})
export class LudzieModule { }
