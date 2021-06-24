package com.siberteam.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PokerHand {
    public final List<PokerCard> listPokerCard;

    public PokerHand(String pokerHand) {
        listPokerCard = convertToCollectionPokerCard(pokerHand);
        listPokerCard.sort(new PokerCard());
        new CombinationDeterminant(listPokerCard);
    }

    private List<PokerCard> convertToCollectionPokerCard(String pokerHand) {
        StringTokenizer tokenLine = new StringTokenizer(pokerHand, " \n");
        List<PokerCard> listCard = new ArrayList<>();
        while (tokenLine.hasMoreTokens()) {
            listCard.add(convertCardToPokerCard(tokenLine.nextToken()));
        }
        return listCard;
    }

    private PokerCard convertCardToPokerCard(String card) {
        return new PokerCard(NumberCard.getEnumFromValue((card.charAt(0) - 48)),
                SuitCard.getEnumFromNameShort(String.valueOf(card.charAt(1))));
    }
}
