package com.siberteam.poker.test;

import com.siberteam.poker.PokerCombinations;
import com.siberteam.poker.PokerHand;
import com.siberteam.poker.PokerHandException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerCombinationTest {

    @Test
    public void isHighCardCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("2C 5S 6D QD TD");
        assertEquals(PokerCombinations.HIGH_CARD, pokerHand.getPokerCombination());
    }

    @Test
    public void isPairCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("2C 2S 6D QD TD");
        assertEquals(PokerCombinations.PAIR, pokerHand.getPokerCombination());
    }

    @Test
    public void isTwoPairCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("2C 2S QC QD TD");
        assertEquals(PokerCombinations.TWO_PAIR, pokerHand.getPokerCombination());
    }

    @Test
    public void isThreePairCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("2C 2S 2H QD TD");
        assertEquals(PokerCombinations.THREE_PAIR, pokerHand.getPokerCombination());
    }

    @Test
    public void isStraightCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5C 6S 7H 8D 9D");
        assertEquals(PokerCombinations.STRAIGHT, pokerHand.getPokerCombination());
    }

    @Test
    public void isFlushCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5C QC 6C 8C TC");
        assertEquals(PokerCombinations.FLUSH, pokerHand.getPokerCombination());
    }

    @Test
    public void isFullHouseCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5C 5D 8S 8C 8H");
        assertEquals(PokerCombinations.FULL_HOUSE, pokerHand.getPokerCombination());
    }

    @Test
    public void isFourPairCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5C 5S 5D 5H TC");
        assertEquals(PokerCombinations.FOUR_PAIR, pokerHand.getPokerCombination());
    }

    @Test
    public void isStraightFlushCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5C 6C 7C 8C 9C");
        assertEquals(PokerCombinations.STRAIGHT_FLUSH, pokerHand.getPokerCombination());
    }

    @Test
    public void isRoyalFlushCombination() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("TC QC JC AC KC");
        assertEquals(PokerCombinations.ROYAL_FLUSH, pokerHand.getPokerCombination());
    }

}
