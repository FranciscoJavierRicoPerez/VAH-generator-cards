package com.fjrp.vah.vahgeneratorwar.controller;

import com.fjrp.vah.vahgeneratorwar.dto.CardDTO;
import com.fjrp.vah.vahgeneratorwar.dto.RequestCardsHTMLInfoDTO;
import com.fjrp.vah.vahgeneratorwar.model.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CardController {
    @PostMapping("generateCardsByExcel")
    List<Card> generateCardsByExcel(@RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping()
    List<CardDTO> getAllCards();

    @PostMapping("/sendHTMLCardsInfo")
    void generateCardsByHtmlInformation(@RequestBody RequestCardsHTMLInfoDTO cardsHTMLInfoDTO);

    @PostMapping("/createNewCard")
    void createNewCard(@RequestBody CardDTO cardDTO);
}
