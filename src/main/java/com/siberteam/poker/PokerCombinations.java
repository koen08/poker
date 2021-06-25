package com.siberteam.poker;

public enum PokerCombinations {
    HIGH_CARD("1", 1),
    PAIR("2", 2),
    TWO_PAIR("22", 3),
    THREE_PAIR("3", 4),
    STRAIGHT("5",5),
    FLUSH("6", 6),
    FULL_HOUSE("23", 7),
    FOUR_PAIR("4",8),
    STRAIGHT_FLUSH("7",9),
    ROYAL_FLUSH("8",10);
    private final String viewCombinationInNumber;
    private final Integer power;
    public Integer countInvolvedCard;

    PokerCombinations(String viewCombinationInNumber, Integer power) {
        this.viewCombinationInNumber = viewCombinationInNumber;
        this.power = power;
    }

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
                throw new IllegalArgumentException("No enum constant value" + viewCombinationInNumber);
                /*break*/
        }
        return pc;
    }

    public String getViewCombinationInNumber() {
        return viewCombinationInNumber;
    }

    public Integer getPower() {
        return power;
    }
}
