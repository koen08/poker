package com.siberteam.poker;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CombinationDeterminant {
    private final PokerCombinations pokerCombination;
    private Integer powerCombination = 0;

    public CombinationDeterminant(List<PokerCard> cardValueList) {
        if (isCombinationWithOneSuit(cardValueList)) {
            pokerCombination = determineCombinationsSameSuit(cardValueList);
        } else {
            pokerCombination = definePairsNonSuit(cardValueList);
        }
    }

    public boolean isCombinationWithOneSuit(List<PokerCard> listPokerCard) {
        int counter = 0;
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            if (listPokerCard.get(i).getSuitCard().equals(
                    listPokerCard.get(i + 1).getSuitCard())) {
                counter++;
            }
        }
        return counter == 4;
    }

    public PokerCombinations determineCombinationsSameSuit(List<PokerCard> listPokerCard) {
        PokerCombinations pc;
        if (listPokerCard.get(0).getNumberCard().equals(NumberCard.TEN)
                && listPokerCard.get(4).getNumberCard().equals(NumberCard.ACE)) {
            pc = PokerCombinations.ROYAL_FLUSH;
        } else if (isNumberInOrder(listPokerCard)) {
            pc = PokerCombinations.STRAIGHT_FLUSH;
        } else {
            pc = PokerCombinations.FLUSH;
        }
        powerCombination += calculatePowerCombinationsWithSuit(listPokerCard);
        return pc;
    }

    private Integer calculatePowerCombinationsWithSuit(List<PokerCard> listPokerCard) {
        int power = 0;
        for (PokerCard pokerCard : listPokerCard){
            power += pokerCard.getNumberCard().ordinal();
        }
        return power;
    }

    public boolean isNumberInOrder(List<PokerCard> listPokerCard) {
        int counterOrder = 0;
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            counterOrder += listPokerCard.get(i + 1).getNumberCard().ordinal()
                    - listPokerCard.get(i).getNumberCard().ordinal();
        }
        return counterOrder == 4;
    }

    public PokerCombinations definePairsNonSuit(List<PokerCard> listPokerCard) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            if (listPokerCard.get(i).getNumberCard().equals(
                    listPokerCard.get(i + 1).getNumberCard())) {
                Integer count = map.getOrDefault(listPokerCard.get(i).getNumberCard().ordinal(), 1);
                count++;
                map.put(listPokerCard.get(i).getNumberCard().ordinal(), count);
            }
        }
        if (map.isEmpty()) {
            if (isNumberInOrder(listPokerCard)) {
                map.put(listPokerCard.stream().mapToInt(i -> i.getNumberCard().ordinal()).sum(), 5);
            } else map.put(listPokerCard.get(4).getNumberCard().ordinal(), 1);
        }
        return defineCombinationWithoutSuit(map);
    }

    public PokerCombinations defineCombinationWithoutSuit(Map<Integer, Integer> map) {
        StringBuilder keyCard = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            keyCard.append(entry.getValue());
            powerCombination += entry.getValue() * entry.getKey();
        }
        return PokerCombinations.getEnumFromViewCombinationInNumber(keyCard.toString());
    }

    public PokerCombinations getPokerCombination() {
        return pokerCombination;
    }

    public Integer getPowerCombination() {
        return powerCombination;
    }
}

