package org.vancina.cardswar;

public class Card implements Comparable<Card> {
    public static String[] Suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    public static String[] Ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
        "Queen", "King", "Ace"};

    int suit;
    int rank;

    public Card(int suit, int rank) {
        this.suit = suit % Suits.length;
        this.rank = rank % Ranks.length;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", Ranks[rank], Suits[suit]);
    }

    @Override
    public int compareTo(Card o) {
        int thisCard = suit * 100 + rank;
        int givenCard = o.suit * 100 + o.rank;
        return Integer.compare(thisCard, givenCard);
    }
}
