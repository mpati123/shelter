import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {GatunekControllerService, GatunekDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-gatunek-list',
  templateUrl: './gatunek-list.component.html',
  styleUrls: ['./gatunek-list.component.scss']
})
export class GatunekListComponent implements OnInit {

  gatunki$: Observable<GatunekDto[]> = of([]);

  displayedColumns: string[] = ['id', 'nazwa', 'actions'];

  constructor(
    private router: Router,
    private gatunkiService: GatunekControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadGatunki();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/gatunek', id]);
  }

  onDelete(id: number) {
    this.gatunkiService.deleteGatunek(id).subscribe({
      next: () => {
        this.snackBar.open('Gatunek został usunięty.', 'Zamknij', { duration: 3000 });
        this.loadGatunki();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania gatunku.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadGatunki(): void {
    this.gatunkiService.getAllGatunki('body').subscribe({
      next: (gatunki) => {
        this.gatunki$ = of(gatunki);
      },
      error: (error) => console.error('Błąd podczas pobierania gatunków:', error)
    });
  }

}
