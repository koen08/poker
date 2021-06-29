package com.siberteam.poker;

import java.util.HashMap;
import java.util.Map;

public enum NumberCard {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(36),
    JACK(26),
    QUEEN(33),
    KING(27),
    ACE(17);
    private static final Map<Integer, NumberCard> MAP_NUMBER_CARD = new HashMap<>();
    private final Integer valueCard;

    NumberCard(Integer valueCard) {
        this.valueCard = valueCard;
    }

    static {
        for (NumberCard numberCard : values()) {
            MAP_NUMBER_CARD.put(numberCard.getValueCard(), numberCard);
        }
    }

    public static NumberCard getEnumFromValueCard(Integer valueCard) {
        return MAP_NUMBER_CARD.get(valueCard);
    }

    public Integer getValueCard() {
        return valueCard;
    }
}
