import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import {
  FakturyControllerService,
  FakturyDto,
  LecznicaControllerService, LecznicaDto,
  UpdateFakturyDto,
  ZwierzetaControllerService,
  ZwierzetaDto
} from "../../../api";

@Component({
  selector: 'app-faktury-detail',
  templateUrl: './faktury-detail.component.html',
  styleUrls: ['./faktury-detail.component.scss']
})
export class FakturyDetailComponent implements OnInit {

  faktura!: FakturyDto;

  lecznice: LecznicaDto[] = [];
  zwierzeta: ZwierzetaDto[] = [];

  selectedLecznicaId?: number;
  selectedZwierzeIds: number[] = [];


  constructor(
    private fakturyService: FakturyControllerService,
    private leczniceService: LecznicaControllerService,
    private zwierzetaService: ZwierzetaControllerService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.fakturyService.getFaktura(id).subscribe(faktura => {
      this.faktura = faktura;
      this.selectedLecznicaId = faktura.lecznica?.id;
      this.selectedZwierzeIds = Array.from(faktura.zwierzeta || []).map(z => z.id!);
    });

    this.leczniceService.getAllLecznice().subscribe(data => this.lecznice = data);
    this.zwierzetaService.getAllZwierzeta().subscribe(data => this.zwierzeta = data);
  }

  getZwierzetaNames(f: FakturyDto): string {
    if (!f.zwierzeta) {
      return '';
    }
    return Array.from(f.zwierzeta).map(z => z.imie).join(', ');
  }

  save(): void {
    if (!this.faktura) return;

    const updatePayload: UpdateFakturyDto = {
      id: this.faktura.id!,
      numer: this.faktura.numer,
      data: this.faktura.data,
      kwota: this.faktura.kwota,
      lecznicaId: this.faktura.lecznica?.id,
      zwierzeta: Array.from(this.faktura.zwierzeta || []).map((z: ZwierzetaDto) => z.id!)
    };

    this.fakturyService.updateFaktura(updatePayload).subscribe({
      next: () => {
        this.snackBar.open('Faktura została zaktualizowana', 'Zamknij', { duration: 3000 });
        this.router.navigate(['/faktury']);
      },
      error: () => this.snackBar.open('Wystąpił błąd podczas aktualizacji', 'Zamknij', { duration: 3000 })
    });
  }

}
