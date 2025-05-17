import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto, GatunekControllerService, GatunekDto,
  LecznicaControllerService,
  LecznicaDto, UpdateFakturyDto, UpdateGatunekDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-gatunek-detail',
  templateUrl: './gatunek-detail.component.html',
  styleUrls: ['./gatunek-detail.component.scss']
})
export class GatunekDetailComponent implements OnInit {

  gatunek!: GatunekDto;

  constructor(
    private gatunkiService: GatunekControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.gatunkiService.getGatunekDto(id).subscribe(gatunek => {
      this.gatunek = gatunek;
    });
  }

  save(): void {
    if (!this.gatunek) return;

    const updatePayload: UpdateGatunekDto = {
      id: this.gatunek.id!,
      nazwa: this.gatunek.nazwa
    };

    this.gatunkiService.updateGatunek(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Gatunek został zaktualizowany', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/gatunek']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }


}
