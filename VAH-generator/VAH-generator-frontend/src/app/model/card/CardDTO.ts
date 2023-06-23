export class CardDTO {
    id: string;
    cardType: string;
    cardBody: string;

    constructor(id?: string, cardType?: string, cardBody?:string) {
        this.id = id ?? "";
        this.cardType = cardType ?? "";
        this.cardBody = cardBody ?? "";
    }
    
}