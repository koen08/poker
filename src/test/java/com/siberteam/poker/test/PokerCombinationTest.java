package com.siberteam.poker.test;

import com.siberteam.poker.PokerCombinations;
import com.siberteam.poker.PokerHand;
import com.siberteam.poker.PokerHandException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerCombinationTest {

    @Test
    public void isHighCardCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("2C 5S 6D QD TD");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.HIGH_CARD.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isPairCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("2C 2S 6D QD TD");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.PAIR.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isTwoPairCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("2C 2S QC QD TD");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.TWO_PAIR.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isThreePairCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("2C 2S 2H QD TD");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.THREE_PAIR.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isStraightCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("5C 6S 7H 8D 9D");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.STRAIGHT.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isFlushCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("5C QC 6C 8C TC");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.FLUSH.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isFullHouseCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("5C 5D 5S 8C 8H");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.FULL_HOUSE.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isFourPairCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("5C 5S 5D 5H TC");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.FOUR_PAIR.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isStraightFlushCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("5C 6C 7C 8C 9C");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.STRAIGHT_FLUSH.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

    @Test
    public void isRoyalFlushCombination() {
        PokerHand pokerHand = null;
        try {
            pokerHand = new PokerHand("TC QC JC AC KC");
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
        assertEquals(PokerCombinations.ROYAL_FLUSH.name(), pokerHand != null ? pokerHand.getNamePokerCombination() : null);
    }

}
