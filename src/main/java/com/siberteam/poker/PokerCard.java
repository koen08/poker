package com.siberteam.poker;

import java.util.Comparator;
import java.util.Objects;

public class PokerCard {
    private final NumberCard numberCard;
    private final SuitCard suitCard;

    public PokerCard(NumberCard numberCard, SuitCard suitCard) {
        this.numberCard = numberCard;
        this.suitCard = suitCard;
    }

    public NumberCard getNumberCard() {
        return numberCard;
    }

    public SuitCard getSuitCard() {
        return suitCard;
    }

    public static final Comparator<PokerCard> compare = Comparator.comparing(o -> o.numberCard.ordinal());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerCard pokerCard = (PokerCard) o;
        return numberCard.equals(pokerCard.numberCard)
                && suitCard.equals(pokerCard.suitCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, suitCard);
    }
}
