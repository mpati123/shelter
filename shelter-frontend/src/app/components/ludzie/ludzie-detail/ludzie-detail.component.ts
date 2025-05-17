import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto,
  LecznicaControllerService,
  LecznicaDto, LudzieControllerService, LudzieDto, UpdateFakturyDto, UpdateLudzieDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-ludzie-detail',
  templateUrl: './ludzie-detail.component.html',
  styleUrls: ['./ludzie-detail.component.scss']
})
export class LudzieDetailComponent implements OnInit {

  czlowiek!: LudzieDto;

  constructor(
    private ludzieService: LudzieControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.ludzieService.getLudzieDto(id).subscribe(czlowiek => {
      this.czlowiek = czlowiek;
    });
  }

  save(): void {
    if (!this.czlowiek) return;

    const updatePayload: UpdateLudzieDto = {
      id: this.czlowiek.id!,
      imie: this.czlowiek.imie,
      nazwisko: this.czlowiek.nazwisko,
      email: this.czlowiek.email,
      telefon: this.czlowiek.telefon
    };

    this.ludzieService.updateLudzie(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Człowiek został zaktualizowany', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/ludzie']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }
}
