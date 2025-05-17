
import { LudzieDto } from './ludzieDto';


export interface PracownicyDto {
    id?: number;
    uuid?: string;
    czlowiek?: LudzieDto;
    stanowisko?: string;
}

