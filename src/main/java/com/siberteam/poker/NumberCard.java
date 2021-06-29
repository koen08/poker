package com.siberteam.poker;

import java.util.HashMap;
import java.util.Map;

public enum NumberCard {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');
    private static final Map<Character, NumberCard> MAP_NUMBER_CARD = new HashMap<>();
    private final Character character;

    NumberCard(Character character) {
        this.character = character;
    }

    static {
        for (NumberCard numberCard : values()) {
            MAP_NUMBER_CARD.put(numberCard.getCharacter(), numberCard);
        }
    }

    public static NumberCard getEnumFromValueCard(Character valueCard) {
        return MAP_NUMBER_CARD.get(valueCard);
    }

    public Character getCharacter() {
        return character;
    }
}
