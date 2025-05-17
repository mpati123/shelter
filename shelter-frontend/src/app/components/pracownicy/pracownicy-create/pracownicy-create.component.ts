import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreatePracownicyDto,
  FakturyControllerService,
  LecznicaControllerService,
  LecznicaDto, LudzieControllerService, LudzieDto, PracownicyControllerService,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StanowiskoEnum, StanowiskoLabels} from "../../../shared/enums/stanowisko.enum";

@Component({
  selector: 'app-pracownicy-create',
  templateUrl: './pracownicy-create.component.html',
  styleUrls: ['./pracownicy-create.component.scss']
})
export class PracownicyCreateComponent  implements OnInit {

  pracownik: CreatePracownicyDto = {
    czlowiekId: undefined,
    stanowisko: ''
  };
  stanowiska = Object.values(StanowiskoEnum);
  stanowiskoLabels = StanowiskoLabels;

  ludzie: LudzieDto[] = [];

  constructor(
    private pracownicyService: PracownicyControllerService,
    private ludzieService: LudzieControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.loadLudzie();
  }

  loadLudzie(): void {
    this.ludzieService.getAllLudzie().subscribe(ludzie => this.ludzie = ludzie);
  }

  create(): void {
    const payload: CreatePracownicyDto = {
      ...this.pracownik
    };

    this.pracownicyService.createPracownik(payload).subscribe({
      next: () => {
        this.snackBar.open('Pracownik został dodany', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/pracownicy']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania pracownika', 'Zamknij', { duration: 3000 });
      }
    });
  }

}
