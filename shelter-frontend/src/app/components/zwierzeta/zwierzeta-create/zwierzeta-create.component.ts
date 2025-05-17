import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreateZwierzetaDto,
  FakturyControllerService, GatunekControllerService, GatunekDto,
  LecznicaControllerService,
  LecznicaDto, PracownicyControllerService, PracownicyDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StanEnum, StanLabels} from "../../../shared/enums/stan.enum";
import {MiejsceEnum, MiejsceLabels} from "../../../shared/enums/miejsce.enum";

@Component({
  selector: 'app-zwierzeta-create',
  templateUrl: './zwierzeta-create.component.html',
  styleUrls: ['./zwierzeta-create.component.scss']
})
export class ZwierzetaCreateComponent  implements OnInit {

  zwierze: CreateZwierzetaDto = {
    imie: '',
    gatunekId: undefined,
    opiekunId: undefined,
    wiek: 0,
    stan: '',
    miejsce: ''
  };

  gatunki: GatunekDto[] = [];
  opiekunowie: PracownicyDto[] = [];

  stany = Object.values(StanEnum);
  stanyLabels = StanLabels;
  miejsca = Object.values(MiejsceEnum);
  miejscaLabels = MiejsceLabels;

  constructor(
    private zwierzetaService: ZwierzetaControllerService,
    private gatunkiService: GatunekControllerService,
    private pracownicyService: PracownicyControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.loadGatunki();
    this.loadOpiekunowie();
  }

  loadGatunki(): void {
    this.gatunkiService.getAllGatunki().subscribe(gatunki => this.gatunki = gatunki);
  }

  loadOpiekunowie(): void {
    this.pracownicyService.getAllPracownicy().subscribe(opiekunowie => this.opiekunowie = opiekunowie);
  }

  create(): void {
    const payload: CreateZwierzetaDto = {
      ...this.zwierze
    };

    this.zwierzetaService.createZwierze(payload).subscribe({
      next: () => {
        this.snackBar.open('Zwierzę zostało dodane', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/zwierzeta']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania zwierzęcia', 'Zamknij', { duration: 3000 });
      }
    });
  }

}
