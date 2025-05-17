import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {FakturyControllerService, FakturyDto, ZbiorkaDto, ZbiorkiControllerService} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-zbiorki-list',
  templateUrl: './zbiorki-list.component.html',
  styleUrls: ['./zbiorki-list.component.scss']
})
export class ZbiorkiListComponent implements OnInit {

  ziorki$: Observable<ZbiorkaDto[]> = of([]);

  displayedColumns: string[] = ['id', 'nazwa', 'cel', 'kwotaDocelowa', 'kwotaZebrana', 'actions'];

  constructor(
    private router: Router,
    private zbiorkiService: ZbiorkiControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadZbiorki();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/zbiorki', id]);
  }

  onDelete(id: number) {
    this.zbiorkiService.deleteZbiorka(id).subscribe({
      next: () => {
        this.snackBar.open('Zbiórka została usunięta.', 'Zamknij', { duration: 3000 });
        this.loadZbiorki();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania zbiórki.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadZbiorki(): void {
    this.zbiorkiService.getAllZbiorki('body').subscribe({
      next: (zbiorki) => {
        this.ziorki$ = of(zbiorki);
      },
      error: (error) => console.error('Błąd podczas pobierania zbiórek:', error)
    });
  }

}
