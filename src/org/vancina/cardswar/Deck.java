package org.vancina.cardswar;

import java.util.ArrayList;
import java.util.Comparator;

public class Deck {
    private ArrayList<Card> cards = null;

    public Deck(int numPacks) {
        cards = new ArrayList<Card>();
        for (int d = 0; d<numPacks; d++)
            for (int s = 0; s<Card.Suits.length; s++)
                for (int r = 0; r<Card.Ranks.length; r++)
                    cards.add(new Card(s, r));
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public void sort() {
        cards.sort(Comparator.naturalOrder());
    }

    public String[] getCards() {
        String[] retDeck = new String[cards.size()];
        for (int c = 0; c<cards.size(); c++) {
            retDeck[c] = cards.get(c).toString();
        }
        return retDeck;
    }

    public void shuffle() {
        for (int x = 0; x<cards.size(); x++) {
            Card t = cards.get(x);
            int r = (int) (Math.random() * cards.size());
            cards.set(x, cards.get(r));
            cards.set(r, t);
        }
    }
}
