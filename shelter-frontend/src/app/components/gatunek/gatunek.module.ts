import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GatunekRoutingModule } from './gatunek-routing.module';
import { GatunekComponent } from './gatunek.component';
import { GatunekListComponent } from './gatunek-list/gatunek-list.component';
import { GatunekDetailComponent } from './gatunek-detail/gatunek-detail.component';
import { GatunekCreateComponent } from './gatunek-create/gatunek-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    GatunekComponent,
    GatunekListComponent,
    GatunekDetailComponent,
    GatunekCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    GatunekRoutingModule
  ]
})
export class GatunekModule { }
