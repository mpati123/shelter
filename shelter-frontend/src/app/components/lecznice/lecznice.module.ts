import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LeczniceRoutingModule } from './lecznice-routing.module';
import { LeczniceComponent } from './lecznice.component';
import { LeczniceListComponent } from './lecznice-list/lecznice-list.component';
import { LeczniceDetailComponent } from './lecznice-detail/lecznice-detail.component';
import { LeczniceCreateComponent } from './lecznice-create/lecznice-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    LeczniceComponent,
    LeczniceListComponent,
    LeczniceDetailComponent,
    LeczniceCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    LeczniceRoutingModule
  ]
})
export class LeczniceModule { }
