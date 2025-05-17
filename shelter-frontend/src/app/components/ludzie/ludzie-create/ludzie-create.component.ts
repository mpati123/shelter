import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreateLudzieDto,
  FakturyControllerService,
  LecznicaControllerService,
  LecznicaDto, LudzieControllerService,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-ludzie-create',
  templateUrl: './ludzie-create.component.html',
  styleUrls: ['./ludzie-create.component.scss']
})
export class LudzieCreateComponent  implements OnInit {

  czlowiek: CreateLudzieDto = {
    imie: '',
    nazwisko: '',
    email: '',
    telefon: '',
  };

  constructor(
    private ludzieService: LudzieControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
  }

  create(): void {
    const payload: CreateLudzieDto = {
      ...this.czlowiek,
    };

    this.ludzieService.createLudzie(payload).subscribe({
      next: () => {
        this.snackBar.open('Człowiek został dodany', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/ludzie']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania człowieka', 'Zamknij', { duration: 3000 });
      }
    });
  }

}
