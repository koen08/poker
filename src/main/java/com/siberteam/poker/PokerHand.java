package com.siberteam.poker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PokerHand {
    public static final Comparator<PokerHand> pokerHandComparator = new Comparator<PokerHand>() {
        @Override
        public int compare(PokerHand o1, PokerHand o2) {
            Integer firstPower = o1.power;
            Integer secondPower = o2.power;
            if (o1.power.equals(o2.power)) {
                firstPower += o1.combinationDeterminant.powerCombination;
                secondPower += o2.combinationDeterminant.powerCombination;
                if (firstPower.equals(secondPower)) {
                    for (int i = o1.power + 1; i < o1.listPokerCard.size(); i++) {
                        firstPower += o1.listPokerCard.get(i).getNumberCard().getValueCard();
                        secondPower += o2.listPokerCard.get(i).getNumberCard().getValueCard();
                    }
                }
                if (firstPower.equals(secondPower)) {
                    firstPower += o1.listPokerCard.get(4).getNumberCard().getValueCard();
                    secondPower += o2.listPokerCard.get(4).getNumberCard().getValueCard();
                }
            }
            return Integer.compare(firstPower, secondPower);
        }
    };
    private PokerCombinations pokerCombination;
    private List<PokerCard> listPokerCard;
    private String pokerHand;
    private Integer power;
    public CombinationDeterminant combinationDeterminant;

    public PokerHand(String pokerHand) {
        this.pokerHand = pokerHand;
        listPokerCard = convertToCollectionPokerCard(pokerHand);
        listPokerCard.sort(new PokerCard());
        combinationDeterminant = new CombinationDeterminant(listPokerCard);
        pokerCombination = combinationDeterminant.getPokerCombination();
        power = pokerCombination.getPower();
        //power = determinePowerCombination(listPokerCard);
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

    private Integer determinePowerCombination(List<PokerCard> listPokerCard) {
        Integer power = null;
        switch (pokerCombination) {
            case HIGH_CARD: {
                power = listPokerCard.get(4).getNumberCard().getValueCard();
                break;
            }
            case PAIR: {
                power = pokerCombination.getPower();
                break;
            }
            case TWO_PAIR: {
                power = (pokerCombination.ordinal() + listPokerCard.get(4).getNumberCard().getValueCard()) * 10;
                break;
            }
            case THREE_PAIR: {
                power = (pokerCombination.ordinal() + listPokerCard.get(4).getNumberCard().getValueCard()) * 15;
                break;
            }
            case STRAIGHT: {
                power = pokerCombination.ordinal() * 20;
                break;
            }
            case FLUSH: {
                power = pokerCombination.ordinal() * 25;
                break;
            }
            case FULL_HOUSE: {
                power = pokerCombination.ordinal() * 30;
                break;
            }
            case FOUR_PAIR: {
                power = (pokerCombination.ordinal() + listPokerCard.get(4).getNumberCard().getValueCard()) * 35;
                break;
            }
            case STRAIGHT_FLUSH: {
                power = pokerCombination.ordinal() * 40;
                break;
            }
            case ROYAL_FLUSH: {
                power = pokerCombination.ordinal() * 50;
                break;
            }
            default:
                break;
        }
        return power;
    }

    public PokerCombinations getPokerCombination() {
        return pokerCombination;
    }

    public String getPokerHand() {
        return pokerHand;
    }

    public Integer getPower() {
        return power;
    }

    public List<PokerCard> getListPokerCard() {
        return listPokerCard;
    }
}
