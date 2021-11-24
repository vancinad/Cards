package org.vancina.cardswar;

public class Card implements Comparable<Card> {
    public static String[] Suits = {"\u2661", "\u2662", "\u2660", "\u2663"}; //unicode suit characters
    public static String[] Ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    /* These are offsets into the Suits and Ranks arrays */
    int suit;
    int rank;

    public Card(int suit, int rank) {
        this.suit = suit % Suits.length; // use % to prevent out of bounds values
        this.rank = rank % Ranks.length;
    }

    @Override
    public String toString() {
        return String.format("%2s %s", Ranks[rank], Suits[suit]);
    }

    /* compareTo(), from Comparable, enables sorting */
    @Override
    public int compareTo(Card o) {
        int thisCard = compareVal(suit, rank);
        int givenCard = compareVal(o.suit, o.rank);
        return Integer.compare(thisCard, givenCard);
    }

    private int compareVal(int suit, int rank) {
        return rank * 100 + suit;
    }
}
