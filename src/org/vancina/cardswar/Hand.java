package org.vancina.cardswar;

public class Hand extends Shoe {
    Hand(int c, Shoe s) {
        super(0); //initialize with no cards
        for (int x=0; x<c; x++)
            cards.add(s.draw()); //draw card from the shoe and add it to the hand
    }
}
