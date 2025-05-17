import {Component, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {FakturyControllerService, FakturyDto, PracownicyDto, ZwierzetaControllerService, ZwierzetaDto} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StanowiskoEnum, StanowiskoLabels} from "../../../shared/enums/stanowisko.enum";
import {StanEnum, StanLabels} from "../../../shared/enums/stan.enum";
import {MiejsceEnum, MiejsceLabels} from "../../../shared/enums/miejsce.enum";

@Component({
  selector: 'app-zwierzeta-list',
  templateUrl: './zwierzeta-list.component.html',
  styleUrls: ['./zwierzeta-list.component.scss']
})
export class ZwierzetaListComponent implements OnInit {

  zwierzeta$: Observable<ZwierzetaDto[]> = of([]);

  displayedColumns: string[] = ['id', 'imie', 'gatunek', 'opiekun', 'wiek', 'stan', 'miejsce', 'actions'];

  columnMappings: { [key: string]: (element: ZwierzetaDto) => string } = {
    id: (p) => p.id?.toString() || '',
    imie: (p) => p.imie || '',
    gatunek: (p) => p.gatunek?.nazwa || '',
    opiekun: (p) => p.opiekun?.czlowiek
      ? `${p.opiekun.czlowiek.imie || ''} ${p.opiekun.czlowiek.nazwisko || ''}`.trim()
      : '',
    wiek: (p) => p.wiek?.toString() || '',
    stan: (p) => p.stan && StanLabels[p.stan as StanEnum] || '',
    miejsce: (p) => p.miejsce && MiejsceLabels[p.miejsce as MiejsceEnum] || ''
  };

  constructor(
    private router: Router,
    private zwierzetaService: ZwierzetaControllerService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadZwierzeta();
  }

  goToDetails(id: number): void {
    this.router.navigate(['/zwierzeta', id]);
  }

  onDelete(id: number) {
    this.zwierzetaService.deleteZwierzeta(id).subscribe({
      next: () => {
        this.snackBar.open('Zwierzę zostało usunięte.', 'Zamknij', { duration: 3000 });
        this.loadZwierzeta();
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas usuwania zwierzęcia.', 'Zamknij', { duration: 3000 });
      }
    });
  }

  loadZwierzeta(): void {
    this.zwierzetaService.getAllZwierzeta('body').subscribe({
      next: (zwierzeta) => {
        this.zwierzeta$ = of(zwierzeta);
      },
      error: (error) => console.error('Błąd podczas pobierania zwierząt:', error)
    });
  }

}
