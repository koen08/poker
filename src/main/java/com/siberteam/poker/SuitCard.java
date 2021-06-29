package com.siberteam.poker;

import java.util.HashMap;
import java.util.Map;

public enum SuitCard {
    HEARTS('H'),
    SPADES('S'),
    DIAMONDS('D'),
    CLUBS('C');
    private static final Map<Character, SuitCard> MAP_SUIT_CARD = new HashMap<>();
    private final Character character;

    SuitCard(Character character) {
        this.character = character;
    }

    static {
        for (SuitCard suitCard : values()) {
            MAP_SUIT_CARD.put(suitCard.getCharacter(), suitCard);
        }
    }

    public static SuitCard getEnumFromSuit(Character valueCard) {
        return MAP_SUIT_CARD.get(valueCard);
    }

    public Character getCharacter() {
        return character;
    }
}
