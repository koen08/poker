package com.siberteam.poker;

public enum SuitCard {
    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBS;

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
}
