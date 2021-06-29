package com.siberteam.poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PokerHand {
    private final Integer power;
    private final List<PokerCard> listPokerCard;
    private final CombinationDeterminant combinationDeterminant;
    private final String pokerHandInput;

    public PokerHand(String pokerHandInput) throws PokerHandException {
        if (pokerHandInput == null) {
            throw new NullPointerException();
        }
        if (pokerHandInput.isEmpty()) {
            throw new PokerHandException("Poker hand is empty");
        }
        this.pokerHandInput = pokerHandInput;
        listPokerCard = convertToCollectionPokerCard(pokerHandInput);
        if (listPokerCard.size() != 5) {
            throw new PokerHandException("Poker hand less then 5 cards");
        }
        if (isDuplicateCards(listPokerCard)) {
            throw new PokerHandException("Poker card has duplicate suit");
        }
        listPokerCard.sort(PokerCard.compare);
        combinationDeterminant = new CombinationDeterminant(listPokerCard);
        PokerCombinations pokerCombination = combinationDeterminant.getPokerCombination();
        power = pokerCombination.ordinal() + 1;
    }

    private List<PokerCard> convertToCollectionPokerCard(String pokerHand) {
        StringTokenizer tokenLine = new StringTokenizer(pokerHand, " \n");
        List<PokerCard> listCard = new ArrayList<>();
        while (tokenLine.hasMoreTokens()) {
            listCard.add(convertCardToPokerCard(tokenLine.nextToken()));
        }
        return listCard;
    }

    private boolean isDuplicateCards(List<PokerCard> pokerCards) {
        for (int i = 0; i < pokerCards.size() - 1; i++) {
            if (pokerCards.get(i).equals(pokerCards.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    private PokerCard convertCardToPokerCard(String card) {
        return new PokerCard(NumberCard.getEnumFromValueCard((card.charAt(0))),
                SuitCard.getEnumFromSuit(card.charAt(1)));
    }

    public static final Comparator<PokerHand> pokerHandComparator = (o1, o2) -> {
        Integer firstPower = o1.power;
        Integer secondPower = o2.power;
        if (o1.power.equals(o2.power)) {
            firstPower += o1.combinationDeterminant.getPowerCombination();
            secondPower += o2.combinationDeterminant.getPowerCombination();
            if (firstPower.equals(secondPower)) {
                for (int i = o1.power + 1; i < o1.listPokerCard.size(); i++) {
                    firstPower += o1.listPokerCard.get(i).getNumberCard().ordinal();
                    secondPower += o2.listPokerCard.get(i).getNumberCard().ordinal();
                }
                firstPower += o1.listPokerCard.get(4).getNumberCard().ordinal();
                secondPower += o2.listPokerCard.get(4).getNumberCard().ordinal();
            }
        }
        return Integer.compare(firstPower, secondPower);
    };

    public PokerCombinations getPokerCombination() {
        return combinationDeterminant.getPokerCombination();
    }

    public String getPokerHandInput() {
        return pokerHandInput;
    }
}
