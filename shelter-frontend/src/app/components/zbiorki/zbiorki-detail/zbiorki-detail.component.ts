import {Component, OnInit} from '@angular/core';
import {
  FakturyControllerService,
  FakturyDto,
  LecznicaControllerService,
  LecznicaDto, UpdateFakturyDto, UpdateZbiorkaDto, ZbiorkaDto, ZbiorkiControllerService,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-zbiorki-detail',
  templateUrl: './zbiorki-detail.component.html',
  styleUrls: ['./zbiorki-detail.component.scss']
})
export class ZbiorkiDetailComponent implements OnInit {

  zbiorka!: ZbiorkaDto;

  zwierzeta: ZwierzetaDto[] = [];

  selectedZwierzeIds: number[] = [];


  constructor(
    private zbiorkiService: ZbiorkiControllerService,
    private zwierzetaService: ZwierzetaControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.zbiorkiService.getZbiorkaDto(id).subscribe(zbiorka => {
      this.zbiorka = zbiorka;
      this.selectedZwierzeIds = Array.from(zbiorka.zwierzeta || []).map(z => z.id!);
    });

    this.zwierzetaService.getAllZwierzeta().subscribe(data => this.zwierzeta = data);
  }

  getZwierzetaNames(f: FakturyDto): string {
    if (!f.zwierzeta) {
      return '';
    }
    return Array.from(f.zwierzeta).map(z => z.imie).join(', ');
  }

  save(): void {
    if (!this.zbiorka) return;

    const updatePayload: UpdateZbiorkaDto = {
      id: this.zbiorka.id!,
      nazwa: this.zbiorka.nazwa,
      cel: this.zbiorka.cel,
      kwotaDocelowa: this.zbiorka.kwotaDocelowa,
      kwotaZebrana: this.zbiorka.kwotaZebrana,
      zwierzeta: Array.from(this.zbiorka.zwierzeta || []).map((z: ZwierzetaDto) => z.id!)
    };

    this.zbiorkiService.updateZbiorka(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Zbiórka została zaktualizowana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/zbiorki']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }

}
