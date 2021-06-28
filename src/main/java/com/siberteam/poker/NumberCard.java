package com.siberteam.poker;

public enum NumberCard {
    TWO(2, null),
    THREE(3, null),
    FOUR(4, null),
    FIVE(5, null),
    SIX(6, null),
    SEVEN(7, null),
    EIGHT(8, null),
    NINE(9, null),
    TEN(10, "T"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");
    private final Integer valueCard;
    private final String nameShort;

    NumberCard(Integer valueCard, String nameShort) {
        this.valueCard = valueCard;
        this.nameShort = nameShort;
    }

    public static NumberCard getEnumFromValue(Integer valueCard) {
        NumberCard numberCard = null;
        switch (valueCard) {
            case 2:
                numberCard = TWO;
                break;
            case 3:
                numberCard = THREE;
                break;
            case 4:
                numberCard = FOUR;
                break;
            case 5:
                numberCard = FIVE;
                break;
            case 6:
                numberCard = SIX;
                break;
            case 7:
                numberCard = SEVEN;
                break;
            case 8:
                numberCard = EIGHT;
                break;
            case 9:
                numberCard = NINE;
                break;
            case 36:
                numberCard = TEN;
                break;
            case 26:
                numberCard = JACK;
                break;
            case 33:
                numberCard = QUEEN;
                break;
            case 27:
                numberCard = KING;
                break;
            case 17:
                numberCard = ACE;
                break;
            default:
                throw new IllegalArgumentException("No enum constant value - " + valueCard);
                /* falls through. */
        }
        return numberCard;
    }

    public Integer getValueCard() {
        return valueCard;
    }

    public String getNameShort() {
        return nameShort;
    }
}
