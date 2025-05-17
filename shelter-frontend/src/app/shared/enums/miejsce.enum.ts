export enum MiejsceEnum {
  LECZNICA = 'LECZNICA',
  SCHRONISKO = 'SCHRONISKO',
  DOM_TYMCZASOWY = 'DOM_TYMCZASOWY',
  DOM_STALY = 'DOM_STALY',
}

export const MiejsceLabels: Record<MiejsceEnum, string> = {
  [MiejsceEnum.LECZNICA]: 'Lecznica',
  [MiejsceEnum.SCHRONISKO]: 'Schronisko',
  [MiejsceEnum.DOM_TYMCZASOWY]: 'Dom tymczasowy',
  [MiejsceEnum.DOM_STALY]: 'Dom staly'
};



