import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import { FakturyControllerService, FakturyDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";


@Component({
  selector: 'app-faktury-list',
  templateUrl: './faktury-list.component.html',
  styleUrls: ['./faktury-list.component.scss']
})
export class FakturyListComponent implements OnInit {

  faktury$: Observable<FakturyDto[]> = of([]);

  displayedColumns: string[] = ['id', 'numer', 'data', 'kwota', 'actions'];

  constructor(
    private router: Router,
    private fakturyService: FakturyControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadFaktury();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/faktury', id]);
  }

  onDelete(id: number) {
    this.fakturyService.deleteFaktura(id).subscribe({
      next: () => {
        this.snackBar.open('Faktura została usunięta.', 'Zamknij', { duration: 3000 });
        this.loadFaktury();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania faktury.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadFaktury(): void {
    this.fakturyService.getAllFaktury('body').subscribe({
      next: (faktury) => {
        this.faktury$ = of(faktury);
      },
      error: (error) => console.error('Błąd podczas pobierania faktur:', error)
    });
  }

}
