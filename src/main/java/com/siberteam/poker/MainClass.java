package com.siberteam.poker;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<PokerHand> pokerHands = new ArrayList<>();
        /*pokerHands.add(new PokerHand("2C 3D JS 4S TD"));
        pokerHands.add(new PokerHand("2C 3D JS 4S AD"));
        pokerHands.add(new PokerHand("2C 2D 2S 4S 3D"));
        pokerHands.add(new PokerHand("3S 3H 2S 4S 5D"));
        pokerHands.add(new PokerHand("2S 2S 3D 4C 7H"));
        pokerHands.add(new PokerHand("2C 2D 2S 8S QD"));
        pokerHands.add(new PokerHand("2C 2D 2S 4S TD"));
        pokerHands.add(new PokerHand("2C 3D 4S 5S 6D"));
        pokerHands.add(new PokerHand("3C 4D 5S 6S 7D"));
        pokerHands.add(new PokerHand("3C 3D 6S 4S TD"));
        pokerHands.add(new PokerHand("3C 3D 5S 4S 5D"));
        pokerHands.add(new PokerHand("TH JH QH KH AH"));
        pokerHands.add(new PokerHand("2H 2S 3H 5H 6H"));
        pokerHands.add(new PokerHand("2H 3H 4H 5H 6H"));
        pokerHands.add(new PokerHand("2H 2S 2D 2C AH"));
        pokerHands.add(new PokerHand("3H 3S 3D 3C TH"));*/
        pokerHands.add(new PokerHand("2S 2S 4D 5C 7H"));
        pokerHands.add(new PokerHand("2S 2S 3D 4C 9H"));
        pokerHands.add(new PokerHand("3C 3D 6S 4S TD"));
        pokerHands.add(new PokerHand("3S 3H 2S 4S 5D"));
        pokerHands.add(new PokerHand("2H 2S 3H 5H 6H"));


        pokerHands.sort(PokerHand.pokerHandComparator);
        pokerHands.stream().map(pokerHand -> pokerHand.getPokerCombination() + " = " + pokerHand.getPokerHand() + " = " + pokerHand.getPower() + " = " + pokerHand.combinationDeterminant.powerCombination)
                .forEach(System.out::println);
    }
}
