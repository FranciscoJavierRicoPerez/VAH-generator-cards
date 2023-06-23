package com.fjrp.vah.vahgeneratorwar.controller;

import com.fjrp.vah.vahgeneratorwar.dto.CardDTO;
import com.fjrp.vah.vahgeneratorwar.dto.RequestCardsHTMLInfoDTO;
import com.fjrp.vah.vahgeneratorwar.model.Card;
import com.fjrp.vah.vahgeneratorwar.service.CardService;
import com.fjrp.vah.vahgeneratorwar.service.CardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/card")
public class CardControllerImpl implements CardController{
    private final static Logger logger =
            LoggerFactory.getLogger(CardControllerImpl.class);
    @Autowired
    private CardService cardService;

    @PostMapping("/generateCardsByExcel")
    public List<Card> generateCardsByExcel(@RequestParam("file") MultipartFile file)
            throws IOException {
        logger.info("CardControllerImpl.generateCardsByExcel()");
        return cardService.generateCards(file);
    }

    @GetMapping("/")
    public List<CardDTO> getAllCards() {
        logger.info("CardControllerImpl.getAllCards()");
        List<CardDTO> cardDTOList = new ArrayList<>();
        cardDTOList = cardService.getAllCards();
        return cardDTOList;
    }

    @Override
    @PostMapping("sendHTMLCardsInfo")
    public void generateCardsByHtmlInformation(RequestCardsHTMLInfoDTO cardsHTMLInfoDTO) {
        logger.info("CardControllerImpl.generateCardsByHtmlInformation()");
        System.out.println(cardsHTMLInfoDTO.toString());
        // cardService.generateCardsPdf(cardsHTMLInfoDTO);
    }

    @Override
    public void createNewCard(CardDTO cardDTO) {
        logger.info("CardControllerImpl.createNewCard()");
        cardService.createNewCard(cardDTO);
    }

}
