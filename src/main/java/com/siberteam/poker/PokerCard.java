package com.siberteam.poker;

import java.util.Comparator;

public class PokerCard implements Comparator<PokerCard> {
    private NumberCard numberCard;
    private SuitCard suitCard;

    public PokerCard(NumberCard numberCard, SuitCard suitCard) {
        this.numberCard = numberCard;
        this.suitCard = suitCard;
    }
    public PokerCard(){

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

    @Override
    public int compare(PokerCard o1, PokerCard o2) {
        return Integer.compare(o1.numberCard.getValueCard(), o2.numberCard.getValueCard());
    }
}
