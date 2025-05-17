import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreateZbiorkaDto,
  FakturyControllerService,
  LecznicaControllerService,
  LecznicaDto, ZbiorkiControllerService,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-zbiorki-create',
  templateUrl: './zbiorki-create.component.html',
  styleUrls: ['./zbiorki-create.component.scss']
})
export class ZbiorkiCreateComponent  implements OnInit {

  zbiorka: CreateZbiorkaDto = {
    nazwa: '',
    cel: '',
    kwotaDocelowa: 0,
    kwotaZebrana: 0,
    zwierzeta: []
  };

  zwierzeta: ZwierzetaDto[] = [];

  constructor(
    private zbiorkiService: ZbiorkiControllerService,
    private zwierzetaService: ZwierzetaControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.loadZwierzeta();
  }

  loadZwierzeta(): void {
    this.zwierzetaService.getAllZwierzeta().subscribe(zwierzeta => this.zwierzeta = zwierzeta);
  }

  create(): void {
    const payload: CreateZbiorkaDto = {
      ...this.zbiorka,
      zwierzeta: this.zbiorka.zwierzeta || []
    };

    this.zbiorkiService.createZbiorka(payload).subscribe({
      next: () => {
        this.snackBar.open('Zbiórka została dodana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/zbiorki']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania zbiórki', 'Zamknij', { duration: 3000 });
      }
    });
  }
}
