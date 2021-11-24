package org.vancina.cardswar;

public class Hand extends Shoe {
    Hand(int c, Shoe d) {
        super(0);
        for (int x=0; x<c; x++)
            addCard(d.draw());
    }
}
