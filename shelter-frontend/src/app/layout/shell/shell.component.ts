import { Component } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";
import {filter} from "rxjs";

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
  styleUrls: ['./shell.component.scss']
})
export class ShellComponent {breadcrumbs: { label: string, url: string }[] = [];

  constructor(private router: Router) {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      const path = this.router.url.split('/').filter(Boolean);
      this.breadcrumbs = path.map((segment, index) => ({
        label: segment,
        url: '/' + path.slice(0, index + 1).join('/')
      }));
    });
  }

}
