package com.fjrp.vah.vahgeneratorwar.mappers;

import com.fjrp.vah.vahgeneratorwar.dto.CardDTO;
import com.fjrp.vah.vahgeneratorwar.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardMapper {
    CardDTO cardToCardDto(Card card);

    List<CardDTO> cardsToCardsDto(List<Card> cardList);

    Card cardDtoToCard(CardDTO cardDTO);

}
