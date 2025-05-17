import { Component } from '@angular/core';
import {Observable, of} from "rxjs";
import {FakturyControllerService, FakturyDto, LecznicaControllerService, LecznicaDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-lecznice-list',
  templateUrl: './lecznice-list.component.html',
  styleUrls: ['./lecznice-list.component.scss']
})
export class LeczniceListComponent {

  lecznice$: Observable<LecznicaDto[]> = of([]);

  displayedColumns: string[] = ['id', 'nazwa', 'adres', 'telefon', 'actions'];

  constructor(
    private router: Router,
    private leczniceService: LecznicaControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadLecznice();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/lecznice', id]);
  }

  onDelete(id: number) {
    this.leczniceService.deleteLecznica(id).subscribe({
      next: () => {
        this.snackBar.open('Lecznica została usunięta.', 'Zamknij', { duration: 3000 });
        this.loadLecznice();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania lecznicy.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadLecznice(): void {
    this.leczniceService.getAllLecznice('body').subscribe({
      next: (lecznice) => {
        this.lecznice$ = of(lecznice);
      },
      error: (error) => console.error('Błąd podczas pobierania lecznic:', error)
    });
  }

}
