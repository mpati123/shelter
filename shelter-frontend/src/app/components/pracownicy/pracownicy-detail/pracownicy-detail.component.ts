import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto,
  LecznicaControllerService,
  LecznicaDto,
  LudzieControllerService,
  LudzieDto,
  PracownicyControllerService,
  PracownicyDto,
  UpdateFakturyDto,
  UpdatePracownicyDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StanowiskoEnum, StanowiskoLabels} from "../../../shared/enums/stanowisko.enum";

@Component({
  selector: 'app-pracownicy-detail',
  templateUrl: './pracownicy-detail.component.html',
  styleUrls: ['./pracownicy-detail.component.scss']
})
export class PracownicyDetailComponent implements OnInit {

  pracownik!: PracownicyDto;

  ludzie: LudzieDto[] = [];
  stanowiska = Object.values(StanowiskoEnum);
  stanowiskoLabels = StanowiskoLabels;

  selectedCzlowiekId?: number;

  constructor(
    private pracownicyService: PracownicyControllerService,
    private ludzieService: LudzieControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.pracownicyService.getPracownikDto(id).subscribe(pracownik => {
      this.pracownik = pracownik;
      this.selectedCzlowiekId = pracownik.czlowiek?.id;
    });

    this.ludzieService.getAllLudzie().subscribe(data => this.ludzie = data);
  }

  save(): void {
    if (!this.pracownik) return;

    const updatePayload: UpdatePracownicyDto = {
      id: this.pracownik.id!,
      czlowiekId: this.pracownik.czlowiek?.id,
      stanowisko: this.pracownik.stanowisko
    };

    this.pracownicyService.updatePracownik(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Pracownik został zaktualizowany', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/pracownicy']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }

}
