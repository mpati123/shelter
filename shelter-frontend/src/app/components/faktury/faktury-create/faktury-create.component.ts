import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CreateFakturyDto, FakturyControllerService, LecznicaControllerService, ZwierzetaControllerService, LecznicaDto, ZwierzetaDto } from 'src/app/api';

@Component({
  selector: 'app-faktury-create',
  templateUrl: './faktury-create.component.html',
  styleUrls: ['./faktury-create.component.scss']
})
export class FakturyCreateComponent implements OnInit {

  faktura: CreateFakturyDto = {
    numer: '',
    data: '',
    kwota: 0,
    lecznicaId: undefined,
    zwierzeta: []
  };

  lecznice: LecznicaDto[] = [];
  zwierzeta: ZwierzetaDto[] = [];

  constructor(
    private fakturyService: FakturyControllerService,
    private leczniceService: LecznicaControllerService,
    private zwierzetaService: ZwierzetaControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.loadLecznice();
    this.loadZwierzeta();
  }

  loadLecznice(): void {
    this.leczniceService.getAllLecznice().subscribe(lecznice => this.lecznice = lecznice);
  }

  loadZwierzeta(): void {
    this.zwierzetaService.getAllZwierzeta().subscribe(zwierzeta => this.zwierzeta = zwierzeta);
  }

  create(): void {
    const payload: CreateFakturyDto = {
      ...this.faktura,
      zwierzeta: this.faktura.zwierzeta || []
    };

    this.fakturyService.createFaktura(payload).subscribe({
      next: () => {
        this.snackBar.open('Faktura została dodana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/faktury']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania faktury', 'Zamknij', { duration: 3000 });
      }
    });
  }
}
