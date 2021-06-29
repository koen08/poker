package com.siberteam.poker.test;

import com.siberteam.poker.PokerHand;
import com.siberteam.poker.PokerHandException;
import org.junit.Test;

public class PokerNegativeTest {

    @Test(expected = PokerHandException.class)
    public void isNotEmptyInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("");
    }

    @Test(expected = PokerHandException.class)
    public void isNotSizeEqualFiveInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5S 4D 2S");
    }

    @Test(expected = PokerHandException.class)
    public void isDuplicateCardsInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5S 4D 2S 2S 3D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNonSuitCardsInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5S 4V 2Q 2S 3D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNonValueCardsInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("5S 4S 2S 211D 3D");
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNonSameStringInputPokerHand() throws PokerHandException {
        PokerHand pokerHand = new PokerHand("some string");
    }

}
