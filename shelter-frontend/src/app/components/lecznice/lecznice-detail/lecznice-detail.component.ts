import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto,
  LecznicaControllerService,
  LecznicaDto, UpdateFakturyDto, UpdateLecznicaDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-lecznice-detail',
  templateUrl: './lecznice-detail.component.html',
  styleUrls: ['./lecznice-detail.component.scss']
})
export class LeczniceDetailComponent implements OnInit {

  lecznica!: LecznicaDto;

  constructor(
    private leczniceService: LecznicaControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.leczniceService.getLecznicaDto(id).subscribe(lecznica => {
      this.lecznica = lecznica;
    });
  }

  save(): void {
    if (!this.lecznica) return;

    const updatePayload: UpdateLecznicaDto = {
      id: this.lecznica.id!,
      nazwa: this.lecznica.nazwa,
      adres: this.lecznica.adres,
      telefon: this.lecznica.telefon
    };

    this.leczniceService.updateLecznica(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Lecznica została zaktualizowana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/lecznice']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }


}
