package com.siberteam.poker.test;

import com.siberteam.poker.PokerCombinations;
import com.siberteam.poker.PokerHand;
import com.siberteam.poker.PokerHandException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokerSortTest {

    @Test
    public void isMorePairThenHighCard() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2C 5S 6D QD TD"));
            pokerHandList.add(new PokerHand("2C 2S 6D QD TD"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.PAIR.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreTwoPairThenPair() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2D 2H 6D QD QC"));
            pokerHandList.add(new PokerHand("2C 2S 6D QD TD"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.TWO_PAIR.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreThreePairThenTwoPair() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2D 2H 2D 6D QC"));
            pokerHandList.add(new PokerHand("2C 2S 6D QD QS"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.THREE_PAIR.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreStraightThenThreePair() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2D 3H 4D 5D 6C"));
            pokerHandList.add(new PokerHand("2C 2S 2D TD QS"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.STRAIGHT.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreFlushThenStraight() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2D 3H 4D 5D 6C"));
            pokerHandList.add(new PokerHand("2C 6C 3C QC TC"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.FLUSH.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreFullHouseThenFlush() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2C 6C 3C QC TC"));
            pokerHandList.add(new PokerHand("2C 2S 2D QD QS"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.FULL_HOUSE.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreFourPairThenFullHouse() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2C 2S 2D 2C TC"));
            pokerHandList.add(new PokerHand("2C 2S 2D QD QS"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.FOUR_PAIR.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreStraightFlushThenFourPair() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("2C 2S 2D 2C TC"));
            pokerHandList.add(new PokerHand("2C 3C 4C 5C 6C"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.STRAIGHT_FLUSH.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isMoreRoyalFlushThenStraightFlush() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("TC JC QC KC AC"));
            pokerHandList.add(new PokerHand("2C 3C 4C 5C 6C"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals(PokerCombinations.ROYAL_FLUSH.name(), pokerHandList.get(1).getNamePokerCombination());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneHighCardStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("AH 3C 7C TC 6C"));
            pokerHandList.add(new PokerHand("3C 2D QC TH 7H"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("AH 3C 7C TC 6C", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onePairStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("AH AC 7C TC 6C"));
            pokerHandList.add(new PokerHand("3C 3D QC TH 7H"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("AH AC 7C TC 6C", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneTwoPairStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("AH AC 7C TC 6C"));
            pokerHandList.add(new PokerHand("3C 3D QC TH 7H"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("AH AC 7C TC 6C", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneThreePairStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("AH AC AD TC 6C"));
            pokerHandList.add(new PokerHand("3C 3D 3H TH 7H"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("AH AC AD TC 6C", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneStraightStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("3D 4S 5H 6H 7H"));
            pokerHandList.add(new PokerHand("2H 3C 4D 5C 6C"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("3D 4S 5H 6H 7H", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneFlushStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("3D 4D 5D 6D 7D"));
            pokerHandList.add(new PokerHand("2D 3D 4D 5D 6D"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("3D 4D 5D 6D 7D", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneFullHouseStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("3S 3H 6S 6D 6H"));
            pokerHandList.add(new PokerHand("3D 3S 3H 6D 6S"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("3S 3H 6S 6D 6H", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneFourPairStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("3S 3H 3C 3D 6H"));
            pokerHandList.add(new PokerHand("2D 2S 2H 2D 6S"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("3S 3H 3C 3D 6H", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oneStraightFlushStrongerThanOther() {
        try {
            List<PokerHand> pokerHandList = new ArrayList<>();
            pokerHandList.add(new PokerHand("3S 4S 5S 6S 7S"));
            pokerHandList.add(new PokerHand("2D 3D 4D 5D 6D"));
            pokerHandList.sort(PokerHand.pokerHandComparator);
            assertEquals("3S 4S 5S 6S 7S", pokerHandList.get(1).getPokerHandInput());
        } catch (PokerHandException e) {
            e.printStackTrace();
        }
    }
}
