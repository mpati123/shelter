import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ZwierzetaRoutingModule } from './zwierzeta-routing.module';
import { ZwierzetaComponent } from './zwierzeta.component';
import { ZwierzetaListComponent } from './zwierzeta-list/zwierzeta-list.component';
import { ZwierzetaDetailComponent } from './zwierzeta-detail/zwierzeta-detail.component';
import { ZwierzetaCreateComponent } from './zwierzeta-create/zwierzeta-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    ZwierzetaComponent,
    ZwierzetaListComponent,
    ZwierzetaDetailComponent,
    ZwierzetaCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    ZwierzetaRoutingModule
  ]
})
export class ZwierzetaModule { }
