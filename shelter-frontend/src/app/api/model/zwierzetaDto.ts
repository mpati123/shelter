
import { GatunekDto } from './gatunekDto';
import { PracownicyDto } from './pracownicyDto';


export interface ZwierzetaDto {
    id?: number;
    uuid?: string;
    imie?: string;
    gatunek?: GatunekDto;
    opiekun?: PracownicyDto;
    wiek?: number;
    stan?: string;
    miejsce?: string;
}

