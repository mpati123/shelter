import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto, GatunekControllerService, GatunekDto,
  LecznicaControllerService,
  LecznicaDto, PracownicyControllerService, PracownicyDto, UpdateFakturyDto, UpdateZwierzetaDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StanowiskoEnum, StanowiskoLabels} from "../../../shared/enums/stanowisko.enum";
import {StanEnum, StanLabels} from "../../../shared/enums/stan.enum";
import {MiejsceEnum, MiejsceLabels} from "../../../shared/enums/miejsce.enum";

@Component({
  selector: 'app-zwierzeta-detail',
  templateUrl: './zwierzeta-detail.component.html',
  styleUrls: ['./zwierzeta-detail.component.scss']
})
export class ZwierzetaDetailComponent implements OnInit {

  zwierze!: ZwierzetaDto;

  gatunki: GatunekDto[] = [];
  opiekunowie: PracownicyDto[] = [];

  selectedGatunekId?: number;
  selectedOpiekunId?: number;

  stany = Object.values(StanEnum);
  stanyLabels = StanLabels;
  miejsca = Object.values(MiejsceEnum);
  miejscaLabels = MiejsceLabels;


  constructor(
    private zwierzetaService: ZwierzetaControllerService,
    private gatunkiService: GatunekControllerService,
    private pracownicyService: PracownicyControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.zwierzetaService.getZwierzeDto(id).subscribe(zwierze => {
      this.zwierze = zwierze;
      this.selectedGatunekId = zwierze.gatunek?.id;
      this.selectedOpiekunId = zwierze.opiekun?.id;
    });

    this.gatunkiService.getAllGatunki().subscribe(data => this.gatunki = data);
    this.pracownicyService.getAllPracownicy().subscribe(data => this.opiekunowie = data);
  }

  save(): void {
    if (!this.zwierze) return;

    const updatePayload: UpdateZwierzetaDto = {
      id: this.zwierze.id!,
      imie: this.zwierze.imie,
      gatunekId: this.zwierze.gatunek?.id,
      opiekunId: this.zwierze.opiekun?.id,
      wiek: this.zwierze.wiek,
      stan: this.zwierze.stan,
      miejsce: this.zwierze.miejsce
    };

    this.zwierzetaService.updateZwierze(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Zwierzę zostało zaktualizowane', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/zwierzeta']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }
}
