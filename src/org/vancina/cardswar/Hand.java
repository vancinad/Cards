package org.vancina.cardswar;

public class Hand extends Deck {
    Hand(int c, Deck d) {
        super(0);
        for (int x=0; x<c; x++)
            addCard(d.draw());
    }
}
