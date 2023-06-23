import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { RequestCardsHTMLInfoDTO } from 'src/app/model/card/RequestCardsHTMLInfoDTO';
import { CardDTO } from 'src/app/model/card/CardDTO';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private BASE_URL = 'http://localhost:8080/card';

  constructor(private HttpClient: HttpClient) { }

  getAllCards(): Observable<any> {
    return this.HttpClient.get<any>(`${this.BASE_URL}`+'/');
  }

  sendCardsHtml(cardsHtml: RequestCardsHTMLInfoDTO) : Observable<any> {
    return this.HttpClient.post(`${this.BASE_URL}`+'/sendHTMLCardsInfo', cardsHtml)
  }

  createNewCard(card: any): Observable<any> {
    return this.HttpClient.post(`${this.BASE_URL}`+'/createNewCard', card);
  }

}
