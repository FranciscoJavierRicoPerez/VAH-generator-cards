package com.fjrp.vah.vahgeneratorwar.service;

import com.fjrp.vah.vahgeneratorwar.dto.CardDTO;
import com.fjrp.vah.vahgeneratorwar.model.Card;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CardService {

    List<Card> generateCards(MultipartFile file) throws IOException;

    List<CardDTO> getAllCards();

    void createNewCard(CardDTO cardDTO);

}
