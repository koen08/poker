package com.siberteam.poker;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CombinationDeterminant {
    private final PokerCombinations pokerCombination;
    public Integer powerHand;

    public CombinationDeterminant(List<PokerCard> cardValueList) {
        if (isCombinationWithOneSuit(cardValueList)) {
            pokerCombination = determineCombinationsSameSuit(cardValueList);
        } else {
            pokerCombination = definePairsNonSuit(cardValueList);
        }
    }

    public PokerCombinations getPokerCombination() {
        pokerCombination.countInvolvedCard = powerHand;
        return pokerCombination;
    }

    public boolean isCombinationWithOneSuit(List<PokerCard> listPokerCard) {
        int counter = 0;
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            if (listPokerCard.get(i).getSuitCard().getValueSuit().equals(
                    listPokerCard.get(i + 1).getSuitCard().getValueSuit())) {
                counter++;
            }
        }
        return counter == 4;
    }

    public PokerCombinations determineCombinationsSameSuit(List<PokerCard> listPokerCard) {
        PokerCombinations pc;
        if (listPokerCard.get(0).getNumberCard().getValueCard().equals(NumberCard.TEN.getValueCard())
                && listPokerCard.get(4).getNumberCard().getValueCard().equals(NumberCard.ACE.getValueCard())) {
            pc = PokerCombinations.ROYAL_FLUSH;
        } else if (isNumberInOrder(listPokerCard)) {
            pc = PokerCombinations.STRAIGHT_FLUSH;
        } else {
            pc = PokerCombinations.FLUSH;
        }
        return pc;
    }

    public boolean isNumberInOrder(List<PokerCard> listPokerCard) {
        int counterOrder = 0;
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            counterOrder += listPokerCard.get(i + 1).getNumberCard().getValueCard()
                    - listPokerCard.get(i).getNumberCard().getValueCard();
        }
        return counterOrder == 4;
    }

    public PokerCombinations definePairsNonSuit(List<PokerCard> listPokerCard) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            if (listPokerCard.get(i).getNumberCard().getValueCard().equals(
                    listPokerCard.get(i + 1).getNumberCard().getValueCard())) {
                Integer count = map.getOrDefault(listPokerCard.get(i).getNumberCard().getValueCard(), 1);
                count++;
                map.put(listPokerCard.get(i).getNumberCard().getValueCard(), count);
            }
        }
        if (map.isEmpty()) {
            if (isNumberInOrder(listPokerCard)) {
                map.put(listPokerCard.stream().mapToInt(i -> i.getNumberCard().getValueCard()).sum(), 5);
            } else map.put(listPokerCard.get(3).getNumberCard().getValueCard(), 1);
        }
        return defineCombinationWithoutSuit(map);
    }

    public PokerCombinations defineCombinationWithoutSuit(Map<Integer, Integer> map) {
        powerHand = 0;
        StringBuilder keyCard = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            keyCard.append(entry.getValue());
            powerHand += entry.getValue() * entry.getKey();
        }
        return PokerCombinations.getEnumFromViewCombinationInNumber(keyCard.toString());
    }

}

