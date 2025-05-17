
import { ZwierzetaDto } from './zwierzetaDto';


export interface ZbiorkaDto {
    id?: number;
    uuid?: string;
    nazwa?: string;
    cel?: string;
    kwotaDocelowa?: number;
    kwotaZebrana?: number;
    zwierzeta?: Set<ZwierzetaDto>;
}

