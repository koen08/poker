package com.siberteam.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationDeterminant {

    public CombinationDeterminant(List<PokerCard> cardValueList) {
        if (isCombinationWithOneSuit(cardValueList)) {
            System.out.println(determineCombinationsSameSuit(cardValueList));
        } else {
            System.out.println(definePairsNonSuit(cardValueList));
        }
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

    public String determineCombinationsSameSuit(List<PokerCard> listPokerCard) {
        if (listPokerCard.get(0).getNumberCard().getValueCard().equals(NumberCard.TEN.getValueCard())
                && listPokerCard.get(4).getNumberCard().getValueCard().equals(NumberCard.ACE.getValueCard())) {
            return "Это Роял Стрит Флеш";
        }
        if (isNumberInOrder(listPokerCard)) {
            return "Это Стрит Флеш";
        } else {
            return "Это Флеш";
        }
    }

    public boolean isNumberInOrder(List<PokerCard> listPokerCard) {
        int counterOrder = 0;
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            counterOrder += listPokerCard.get(i + 1).getNumberCard().getValueCard()
                    - listPokerCard.get(i).getNumberCard().getValueCard();
        }
        return counterOrder == 4;
    }

    public String definePairsNonSuit(List<PokerCard> listPokerCard) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < listPokerCard.size() - 1; i++) {
            if (!listPokerCard.get(i).getNumberCard().getValueCard().equals(
                    listPokerCard.get(i + 1).getNumberCard().getValueCard())) {
                continue;
            } else if (map.containsKey(listPokerCard.get(i).getNumberCard().getValueCard())) {
                Integer count = map.get(listPokerCard.get(i).getNumberCard().getValueCard());
                count++;
                map.put(listPokerCard.get(i).getNumberCard().getValueCard(), count);
            } else {
                map.put(listPokerCard.get(i).getNumberCard().getValueCard(), 2);
            }
        }
        if (isNumberInOrder(listPokerCard)) {
            map.put(12345, 5);
        }
        if (map.isEmpty()) {
            map.put(listPokerCard.get(3).getNumberCard().getValueCard(), 1);
        }
        return defineCombinationWithoutSuit(map);
    }

    public String defineCombinationWithoutSuit(Map<Integer, Integer> map) {
        StringBuilder keyCard = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            keyCard.append(entry.getValue());
        }
        String keyCardString = keyCard.toString();
        if (keyCardString.equals("2")) {
            return "Это пара";
        }
        if (keyCardString.equals("3")) {
            return "Это сет";
        }
        if (keyCardString.equals("22")) {
            return "Это две пары";
        }
        if (keyCardString.equals("23") || keyCardString.equals("32")) {
            return "Это фулл хаус";
        }
        if (keyCardString.equals("4")) {
            return "Это каре";
        }
        if (keyCardString.equals("5")) {
            return "Это стрит";
        }
        if (keyCardString.equals("1")) {
            return "Старшая карта";
        }
        return "Не смог определить";
    }

}
