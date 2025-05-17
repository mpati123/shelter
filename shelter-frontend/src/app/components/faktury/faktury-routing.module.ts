import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FakturyComponent } from './faktury.component';
import { FakturyListComponent } from './faktury-list/faktury-list.component';
import { FakturyDetailComponent } from './faktury-detail/faktury-detail.component';
import { FakturyCreateComponent } from './faktury-create/faktury-create.component';

const routes: Routes = [
  {
    path: '',
    component: FakturyComponent,
    children: [
      { path: '', component: FakturyListComponent },
      { path: 'create', component: FakturyCreateComponent },
      { path: ':id', component: FakturyDetailComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FakturyRoutingModule {}
