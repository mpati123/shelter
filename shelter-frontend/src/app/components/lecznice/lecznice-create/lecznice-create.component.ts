import {Component, OnInit} from '@angular/core';
import {
  CreateFakturyDto, CreateLecznicaDto,
  FakturyControllerService,
  LecznicaControllerService,
  LecznicaDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-lecznice-create',
  templateUrl: './lecznice-create.component.html',
  styleUrls: ['./lecznice-create.component.scss']
})
export class LeczniceCreateComponent  implements OnInit {

  lecznica: CreateLecznicaDto = {
    nazwa: '',
    adres: '',
    telefon: ''
  };

  constructor(
    private leczniceService: LecznicaControllerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
  }

  create(): void {
    const payload: CreateLecznicaDto = {
      ...this.lecznica,
    };

    this.leczniceService.createLecznica(payload).subscribe({
      next: () => {
        this.snackBar.open('Lecznica została dodana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/lecznice']);
      },
      error: () => {
        this.snackBar.open('Wystąpił błąd podczas dodawania lecznicy', 'Zamknij', { duration: 3000 });
      }
    });
  }
}
