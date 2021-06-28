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
                throw new IllegalArgumentException("No enum constant value - " + nameShort);
                /* falls through. */
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
