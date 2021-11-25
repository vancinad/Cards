package org.vancina.cardswar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Shoe {
    protected ArrayList<Card> cards;

    public Shoe(int numPacks) {
        /*
            Load the shoe with the number of packs requested. Each pack is one complete set of cards -- all ranks/suits
        */
        cards = new ArrayList<>();
        for (int p = 0; p<numPacks; p++)
            for (int s = 0; s<Card.Suits.length; s++)
                for (int r = 0; r<Card.Ranks.length; r++)
                    cards.add(new Card(s, r));
    }

    public Card draw() {
        return cards.remove(0); //Remove and return a card from the top of the deck
    }

    public void sort() {
        cards.sort(Comparator.reverseOrder());
    }

    public String[] getCards() {
        /* Return the string representation of all the cards in the shoe */
        String[] strCards = new String[cards.size()];
        for (int c = 0; c<cards.size(); c++) {
            strCards[c] = cards.get(c).toString();
        }
        return strCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
