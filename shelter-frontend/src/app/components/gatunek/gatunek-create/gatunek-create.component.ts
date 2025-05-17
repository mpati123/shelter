import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreateGatunekDto,
  FakturyControllerService, GatunekControllerService,
  LecznicaControllerService,
  LecznicaDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-gatunek-create',
  templateUrl: './gatunek-create.component.html',
  styleUrls: ['./gatunek-create.component.scss']
})
export class GatunekCreateComponent implements OnInit {

  gatunek: CreateGatunekDto = {
    nazwa: ''
  };

  constructor(
    private gatunkiService: GatunekControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
  }

  create(): void {
    const payload: CreateGatunekDto = {
      ...this.gatunek,
    };

    this.gatunkiService.createGatunek(payload).subscribe({
      next: () => {
        this.snackBar.open('Gatunek została dodana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/gatunek']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania gatunku', 'Zamknij', { duration: 3000 });
      }
    });
  }

}
