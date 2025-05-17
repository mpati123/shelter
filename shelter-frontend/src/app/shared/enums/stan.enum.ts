export enum StanEnum {
  NOWY = 'NOWY',
  DO_SPRAWDZENIA = 'DO_SPRAWDZENIA',
  DO_ADOPCJI = 'DO_ADOPCJI',
  ADOPTOWANY = 'ADOPTOWANY',
}

export const StanLabels: Record<StanEnum, string> = {
  [StanEnum.NOWY]: 'Nowy',
  [StanEnum.DO_SPRAWDZENIA]: 'Do sprawdzenia',
  [StanEnum.DO_ADOPCJI]: 'Do adopcji',
  [StanEnum.ADOPTOWANY]: 'Adoptowany'
};
