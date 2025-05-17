
import { ZwierzetaDto } from './zwierzetaDto';
import { LecznicaDto } from './lecznicaDto';


export interface FakturyDto {
    id?: number;
    uuid?: string;
    numer?: string;
    data?: string;
    kwota?: number;
    lecznica?: LecznicaDto;
    zwierzeta?: Set<ZwierzetaDto>;
}

