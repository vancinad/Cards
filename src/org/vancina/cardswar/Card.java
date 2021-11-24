package org.vancina.cardswar;

public class Card implements Comparable<Card> {
//    public static String[] Suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
/*
    public static String[] Ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
        "Queen", "King", "Ace"};
*/
    public static String[] Suits = {"\u2661", "\u2662", "\u2660", "\u2663"};
    public static String[] Ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
            "Q", "K", "A"};

    int suit;
    int rank;

    public Card(int suit, int rank) {
        this.suit = suit % Suits.length;
        this.rank = rank % Ranks.length;
    }

    @Override
    public String toString() {
        return String.format("%s %s", Ranks[rank], Suits[suit]);
    }

    @Override
    public int compareTo(Card o) {
        int thisCard = compareVal(suit, rank);
        int givenCard = compareVal(o.suit, o.rank);
        return Integer.compare(thisCard, givenCard);
    }

    private int compareVal(int suit, int rank) {
        //return suit * 100 + rank;
        return rank * 100 + suit;
    }
}
