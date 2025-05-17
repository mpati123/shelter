import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {FakturyControllerService, FakturyDto, LudzieControllerService, LudzieDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-ludzie-list',
  templateUrl: './ludzie-list.component.html',
  styleUrls: ['./ludzie-list.component.scss']
})
export class LudzieListComponent implements OnInit {

  ludzie$: Observable<LudzieDto[]> = of([]);

  displayedColumns: string[] = ['id', 'imie', 'nazwisko', 'email', 'telefon', 'actions'];

  constructor(
    private router: Router,
    private ludzieService: LudzieControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadLudzie();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/ludzie', id]);
  }

  onDelete(id: number) {
    this.ludzieService.deleteLudzie(id).subscribe({
      next: () => {
        this.snackBar.open('Człowiek został usunięty.', 'Zamknij', { duration: 3000 });
        this.loadLudzie();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania człowieka.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadLudzie(): void {
    this.ludzieService.getAllLudzie('body').subscribe({
      next: (ludzie) => {
        this.ludzie$ = of(ludzie);
      },
      error: (error) => console.error('Błąd podczas pobierania ludzi:', error)
    });
  }

}
