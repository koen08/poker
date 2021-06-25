package com.siberteam.poker;

public enum SuitCard {
    HEARTS(1, "H"),
    SPADES(2, "S"),
    DIAMONDS(3, "D"),
    CLUBS(4, "C");
    private final Integer valueSuit;
    private final String nameShort;

    SuitCard(Integer valueSuit, String nameShort) {
        this.valueSuit = valueSuit;
        this.nameShort = nameShort;
    }

    public static SuitCard getEnumFromValue(Integer valueSuit) {
        SuitCard suitCard = null;
        switch (valueSuit) {
            case 1:
                suitCard = SuitCard.HEARTS;
                break;
            case 2:
                suitCard = SuitCard.SPADES;
                break;
            case 3:
                suitCard = SuitCard.DIAMONDS;
                break;
            case 4:
                suitCard = SuitCard.CLUBS;
                break;
            default:
                throw new IllegalArgumentException("No enum constant value" + valueSuit);
                /*break*/
        }
        return suitCard;
    }

    public static SuitCard getEnumFromNameShort(String nameShort) {
        SuitCard suitCard = null;
        switch (nameShort) {
            case "H":
                suitCard = SuitCard.HEARTS;
                break;
            case "S":
                suitCard = SuitCard.SPADES;
                break;
            case "D":
                suitCard = SuitCard.DIAMONDS;
                break;
            case "C":
                suitCard = SuitCard.CLUBS;
                break;
            default:
                throw new IllegalArgumentException("No enum constant value" + nameShort);
        }
        return suitCard;
    }

    public Integer getValueSuit() {
        return valueSuit;
    }

    public String getNameShort() {
        return nameShort;
    }
}
