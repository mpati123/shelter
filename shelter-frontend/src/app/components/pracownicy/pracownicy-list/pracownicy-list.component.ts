import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {FakturyControllerService, FakturyDto, PracownicyControllerService, PracownicyDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {formatEnum} from "../../../shared/components/utils/EnumUtils";
import {StanowiskoEnum, StanowiskoLabels} from "../../../shared/enums/stanowisko.enum";

@Component({
  selector: 'app-pracownicy-list',
  templateUrl: './pracownicy-list.component.html',
  styleUrls: ['./pracownicy-list.component.scss']
})
export class PracownicyListComponent implements OnInit {

  pracownicy$: Observable<PracownicyDto[]> = of([]);

  displayedColumns: string[] = ['id', 'imie', 'nazwisko', 'stanowisko', 'actions'];

  columnMappings: { [key: string]: (element: PracownicyDto) => string } = {
    id: (p) => p.id?.toString() || '',
    imie: (p) => p.czlowiek?.imie || '',
    nazwisko: (p) => p.czlowiek?.nazwisko || '',
    stanowisko: (p) => p.stanowisko && StanowiskoLabels[p.stanowisko as StanowiskoEnum] || ''
  };

  constructor(
    private router: Router,
    private pracownicyService: PracownicyControllerService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.loadPracownicy();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/pracownicy', id]);
  }

  onDelete(id: number): void {
    this.pracownicyService.deletePracownik(id).subscribe({
      next: () => {
        this.snackBar.open('Pracownik został usunięty.', 'Zamknij', { duration: 3000 });
        this.loadPracownicy();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania pracownika.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadPracownicy(): void {
    this.pracownicyService.getAllPracownicy('body').subscribe({
      next: (pracownicy) => this.pracownicy$ = of(pracownicy),
      error: (error) => console.error('Błąd podczas pobierania pracowników:', error)
    });
  }
}
