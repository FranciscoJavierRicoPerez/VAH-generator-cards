import { Component, OnInit } from '@angular/core';
import { CardDTO } from 'src/app/model/card/CardDTO';
import { RequestCardsHTMLInfoDTO } from 'src/app/model/card/RequestCardsHTMLInfoDTO';
import { CardService } from 'src/app/services/cardService/card.service';
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-card-info',
  templateUrl: './card-info.component.html',
  styleUrls: ['./card-info.component.css'],
})
export class CardInfoComponent implements OnInit {
  cards: CardDTO[] = [];
  blackCards: CardDTO[] = [];
  whiteCards: CardDTO[] = [];
  showBlackCards: boolean = false;
  showWhiteCards: boolean = false;
  createCardForm = new FormGroup({
    cardType: new FormControl('', Validators.required),
    cardBody: new FormControl('', Validators.required)
  });

  constructor(private CardService: CardService) {}

  ngOnInit(): void {
    this.getAllCards(this.cards);
  }

  changeBlackCardsVisibility() {
    this.showBlackCards = !this.showBlackCards;
  }

  changeWhiteCardsVisibility() {
    this.showWhiteCards = !this.showWhiteCards;
  }

  getAllCards(cards: CardDTO[]) {
    this.CardService.getAllCards().subscribe((data) => {
      data.forEach((element: any) => {
        if (element.cardType === 'CN') {
          this.blackCards.push(element);
        } else {
          this.whiteCards.push(element);
        }
      });
    });
  }

  createNewCard(){
    this.CardService.createNewCard(this.createCardForm.value).subscribe(
      data => {
        console.log('Successfully');
      },
      err => {
        console.log('Error');
      }
    );
  }

  // Metodo que obtiene todo el codigo html de la sección de cartas negras
  /* getBlackCardsSection() {
    let blackCardSection = document.getElementById('sectionBlackCards');
    console.log(blackCardSection);
  } */

  /* getBreakLine(index: number) {
    if(index % 4 === 0) {
      console.log(index + ' => ES MULTIPLO DE 4');
    } else {
      console.log(index + ' => NO ES MULTIPLO DE 4');
    }
    return index % 4 === 0;
  } */

  /* getWhiteCardsSection() {
    // referencias => https://mugan86.medium.com/exportar-pdfs-en-angular-con-jspdf-85c7a11a110f
    let whiteCardSection = document.getElementById('sectionWhiteCards')!;
    // Extraemos el
    const DATA = whiteCardSection;
    const doc = new jsPDF('p', 'pt', 'a4');
    const options = {
      background: 'white',
      scale: 3
    };
    html2canvas(DATA, options).then((canvas) => {

      const img = canvas.toDataURL('image/PNG');
      console.log(img);
      // Add image Canvas to PDF
      const bufferX = 15;
      const bufferY = 15;
      const imgProps = (doc as any).getImageProperties(img);
      const pdfWidth = doc.internal.pageSize.getWidth() - 2 * bufferX;
      const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;
      doc.addImage(img, 'PNG', bufferX, bufferY, pdfWidth, pdfHeight, undefined, 'FAST');
      return doc;
    }).then((docResult) => {
      docResult.save(`${new Date().toISOString()}_whiteCards.pdf`);
    });
  } */
}
