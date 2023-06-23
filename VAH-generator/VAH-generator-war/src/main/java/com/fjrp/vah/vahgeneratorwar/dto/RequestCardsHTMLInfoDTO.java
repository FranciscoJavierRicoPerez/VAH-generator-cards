package com.fjrp.vah.vahgeneratorwar.dto;

import lombok.Data;

@Data
public class RequestCardsHTMLInfoDTO {
    private String cardsHtml;
    private Boolean isBlackCard;
    private Boolean isWhiteCard;
}
