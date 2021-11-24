package org.vancina.cardswar;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        /*
            Deal cards for a given number of players, with given number of cards per hand.
         */

        /* Find out how many players and cards are needed */
        Scanner kb = new Scanner(System.in);
        System.out.print("\nNumber of players? ");
        int numPlayers = kb.nextInt();
        System.out.print("Cards per hand? ");
        int handCards = kb.nextInt();

        int cardsNeeded = numPlayers * handCards;

        /* Now find how many packs are required to get that number of cards */
        int packSize = Card.Suits.length * Card.Ranks.length; // # of cards in each pack
        int packsNeeded = cardsNeeded / packSize;
        if (cardsNeeded % packSize > 0)
            packsNeeded+=1; //round up if there's a remainder
        System.out.printf("\nNeed %d cards, %d pack", cardsNeeded, packsNeeded);
        if (packsNeeded > 1) System.out.print("s"); //good grammar for plural

        /* Generate and shuffle cards */
        Shoe gameShoe = new Shoe(packsNeeded);
        gameShoe.shuffle();

        /* Now deal the cards to each player */
        ArrayList<Hand> playerHands = new ArrayList<>(); // array for player hands

        for (int p = 0; p<numPlayers; p++) {
            System.out.printf("\n\nDrawing player %d's hand...", p+1);
            Hand h = new Hand(handCards, gameShoe); // create new hand by drawing cards out of the shoe
            playerHands.add(h);
            printCards(h);
        }

        /* All hands are dealt -- print them out */
        printHands(playerHands);

        /* Print the unused cards */
        gameShoe.sort();
        System.out.print("\nCards remaining...");
        if (printCards(gameShoe).length == 0)
            System.out.print("*** none ***");
    }

    private static void printHands(ArrayList<Hand> hands) {
        int numCards = hands.get(0).getCards().length; //use first hand to learn # of cards per hand
        int numHands = hands.size();

        /* Print a header with "Player n" for each hand */
        StringBuffer header = new StringBuffer();
        header.append("\n\n     ");
        for (int x = 0; x<numHands; x++)
            header.append(String.format("Player %d            ", x+1));
        System.out.println(header);

        /* Print hands in columns */
        for (int c = 0; c<numCards; c++) { // cards in rows
            System.out.printf("%3d) ", c+1);
            /* Print a line for card c from each hand */
            for (Hand hand : hands) { // hands in columns
                if (c == 0) hand.sort(); //sort hand, but only once
                System.out.printf("%-20s", hand.getCards()[c]); //implicit Card.toString() invocation -- Yay Java!
            }
            System.out.println();
        }
    }

    private static String[] printCards(Shoe s) {
        String [] c = s.getCards();

        for (int x = 0; x<c.length; x++)
            System.out.printf("\n%2d) %s", x+1, c[x]); //one line per card

        return c; // return the array in case caller wants to do something with it
    }
}
