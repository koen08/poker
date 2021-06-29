package com.siberteam.poker;

public enum PokerCombinations {
    HIGH_CARD,
    PAIR,
    TWO_PAIR,
    THREE_PAIR,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_PAIR,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;

    public static PokerCombinations getEnumFromViewCombinationInNumber(String viewCombinationInNumber) {
        PokerCombinations pc;
        switch (viewCombinationInNumber) {
            case "1":
                pc = PokerCombinations.HIGH_CARD;
                break;
            case "2":
                pc = PokerCombinations.PAIR;
                break;
            case "22":
                pc = PokerCombinations.TWO_PAIR;
                break;
            case "3":
                pc = PokerCombinations.THREE_PAIR;
                break;
            case "32":
            case "23":
                pc = PokerCombinations.FULL_HOUSE;
                break;
            case "4":
                pc = PokerCombinations.FOUR_PAIR;
                break;
            case "5":
                pc = PokerCombinations.STRAIGHT;
                break;
            case "6":
                pc = PokerCombinations.FLUSH;
                break;
            case "7":
                pc = PokerCombinations.STRAIGHT_FLUSH;
                break;
            case "8":
                pc = PokerCombinations.ROYAL_FLUSH;
                break;
            default:
                throw new IllegalArgumentException("No enum constant value - " + viewCombinationInNumber);
                /* falls through. */
        }
        return pc;
    }
}
