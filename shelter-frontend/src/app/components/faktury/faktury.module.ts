import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FakturyRoutingModule } from './faktury-routing.module';
import { FakturyComponent } from './faktury.component';
import { FakturyListComponent } from './faktury-list/faktury-list.component';
import { FakturyDetailComponent } from './faktury-detail/faktury-detail.component';
import { FakturyCreateComponent } from './faktury-create/faktury-create.component';
import {SharedModule} from "../../shared.module";


@NgModule({
  declarations: [
    FakturyComponent,
    FakturyListComponent,
    FakturyDetailComponent,
    FakturyCreateComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    FakturyRoutingModule
  ]
})
export class FakturyModule { }
