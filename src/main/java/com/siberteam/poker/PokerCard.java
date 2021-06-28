package com.siberteam.poker;

import java.util.Comparator;
import java.util.Objects;

public class PokerCard {
    private NumberCard numberCard;
    private SuitCard suitCard;

    public PokerCard(NumberCard numberCard, SuitCard suitCard) {
        this.numberCard = numberCard;
        this.suitCard = suitCard;
    }

    public NumberCard getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(NumberCard numberCard) {
        this.numberCard = numberCard;
    }

    public SuitCard getSuitCard() {
        return suitCard;
    }

    public void setSuitCard(SuitCard suitCard) {
        this.suitCard = suitCard;
    }

    public static final Comparator<PokerCard> compare = Comparator.comparing(o -> o.numberCard.getValueCard());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerCard pokerCard = (PokerCard) o;
        return numberCard.getValueCard().equals(pokerCard.numberCard.getValueCard())
                && suitCard.getValueSuit().equals(pokerCard.suitCard.getValueSuit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, suitCard);
    }
}
