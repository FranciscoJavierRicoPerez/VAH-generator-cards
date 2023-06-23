package com.fjrp.vah.vahgeneratorwar.service;

import com.fjrp.vah.vahgeneratorwar.dto.CardDTO;
import com.fjrp.vah.vahgeneratorwar.mappers.CardMapper;
import com.fjrp.vah.vahgeneratorwar.model.Card;
import com.fjrp.vah.vahgeneratorwar.repository.CardRepository;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Service
public class CardServiceImpl implements CardService {

    private final static Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    @Autowired
    private CardRepository cardRepository;

    private final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);


    @Override
    public List<Card> generateCards(MultipartFile multipartFile) throws IOException {
        logger.info("Starting the generation of the cards");
        File file = new File("C:/Users/RiCo9/Downloads/" + multipartFile.getOriginalFilename());
        FileInputStream inputStream = new FileInputStream(file);
        List<Card> cardList = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        DataFormatter formatter = new DataFormatter();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String contenidoCelda = formatter.formatCellValue(cell);
                System.out.println("celda: " + contenidoCelda);
                Card card = new Card();
                String[] cardsParts = contenidoCelda.split(":");
                card.setCardType(cardsParts[0]);
                card.setCardBody(cardsParts[1]);
                cardList.add(card);
            }
        }
        saveCardList(cardList);
        return cardList;
    }

    @Override
    public List<CardDTO> getAllCards() {
        logger.info("Getting all the cards");
        List<CardDTO> cards = cardMapper.cardsToCardsDto(cardRepository.findAll());
        // return cardMapper.cardsToCardsDto(cardRepository.findAll());
        return cards;
    }

    @Override
    public void createNewCard(CardDTO cardDTO) {
        cardDTO.setCardBody(refactorSpaces(cardDTO.getCardBody()));
        cardRepository.save(cardMapper.cardDtoToCard(cardDTO));
    }

    private String refactorSpaces(String cardBody) {
        String newCardBody = "";
        if(cardBody.contains("_")){
            // Existe un problema si la _ es el último caracter del texto se produce un error
            String [] parts = cardBody.split("_");
            String underline = "_______";
            newCardBody = parts[0] + underline + parts[1];
        } else {
            newCardBody = cardBody;
        }
        return newCardBody;
    }

    private void saveCardList(List<Card> cardList) {
        for (Card card : cardList) {
            logger.info("{} created succesfully", card);
            cardRepository.save(card);
        }
    }


}
