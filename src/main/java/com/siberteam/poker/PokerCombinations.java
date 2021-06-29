package com.siberteam.poker;

import java.util.HashMap;
import java.util.Map;

public enum PokerCombinations {
    HIGH_CARD(10),
    PAIR(20),
    TWO_PAIR(4),
    THREE_PAIR(30),
    STRAIGHT(50),
    FLUSH(null),
    FULL_HOUSE(5),
    FOUR_PAIR(40),
    STRAIGHT_FLUSH(null),
    ROYAL_FLUSH(null);
    private static final Map<Integer, PokerCombinations> MAP_COMBINATION_CARD = new HashMap<>();
    private final Integer valueCombination;

    PokerCombinations(Integer valueCombination) {
        this.valueCombination = valueCombination;
    }

    static {
        for (PokerCombinations pokerCombinations : values()) {
            MAP_COMBINATION_CARD.put(pokerCombinations.getNameCombination(), pokerCombinations);
        }
    }

    public static PokerCombinations getEnumFromNameCombination(Integer valueCombination) {
        return MAP_COMBINATION_CARD.get(valueCombination);
    }

    public Integer getNameCombination() {
        return valueCombination;
    }
}
