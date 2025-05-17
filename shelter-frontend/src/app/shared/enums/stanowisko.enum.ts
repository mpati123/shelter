export enum StanowiskoEnum {
  DYREKTOR = 'DYREKTOR',
  PRACOWNIK = 'PRACOWNIK',
  WOLONTARIUSZ = 'WOLONTARIUSZ',
  LEKARZ = 'LEKARZ',
}

export const StanowiskoLabels: Record<StanowiskoEnum, string> = {
  [StanowiskoEnum.DYREKTOR]: 'Dyrektor',
  [StanowiskoEnum.PRACOWNIK]: 'Pracownik',
  [StanowiskoEnum.WOLONTARIUSZ]: 'Wolontariusz',
  [StanowiskoEnum.LEKARZ]: 'Lekarz'
};
