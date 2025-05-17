import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ZbiorkiRoutingModule } from './zbiorki-routing.module';
import { ZbiorkiComponent } from './zbiorki.component';
import { ZbiorkiListComponent } from './zbiorki-list/zbiorki-list.component';
import { ZbiorkiDetailComponent } from './zbiorki-detail/zbiorki-detail.component';
import { ZbiorkiCreateComponent } from './zbiorki-create/zbiorki-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    ZbiorkiComponent,
    ZbiorkiListComponent,
    ZbiorkiDetailComponent,
    ZbiorkiCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    ZbiorkiRoutingModule
  ]
})
export class ZbiorkiModule { }
