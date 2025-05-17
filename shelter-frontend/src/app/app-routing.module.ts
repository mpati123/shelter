import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShellComponent } from './layout/shell/shell.component';

const routes: Routes = [
  {
    path: '',
    component: ShellComponent,
    children: [
      { path: 'faktury', loadChildren: () => import('./components/faktury/faktury.module').then(m => m.FakturyModule) },
      { path: 'zbiorki', loadChildren: () => import('./components/zbiorki/zbiorki.module').then(m => m.ZbiorkiModule) },
      { path: 'ludzie', loadChildren: () => import('./components/ludzie/ludzie.module').then(m => m.LudzieModule) },
      { path: 'pracownicy', loadChildren: () => import('./components/pracownicy/pracownicy.module').then(m => m.PracownicyModule) },
      { path: 'lecznice', loadChildren: () => import('./components/lecznice/lecznice.module').then(m => m.LeczniceModule) },
      { path: 'zwierzeta', loadChildren: () => import('./components/zwierzeta/zwierzeta.module').then(m => m.ZwierzetaModule) },
      { path: 'gatunek', loadChildren: () => import('./components/gatunek/gatunek.module').then(m => m.GatunekModule) }
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
