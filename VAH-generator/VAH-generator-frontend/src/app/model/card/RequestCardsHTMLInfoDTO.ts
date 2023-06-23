export class RequestCardsHTMLInfoDTO {
  cardsHtml: string;
  isBlackCard: boolean;
  isWhiteCard: boolean;

  constructor(cardsHtml?: string, isBlackCard?: boolean, isWhiteCard?: boolean) {
    this.cardsHtml = cardsHtml ?? '';
    this.isBlackCard = isBlackCard ?? false;
    this.isWhiteCard = isWhiteCard ?? false;
  }
}
