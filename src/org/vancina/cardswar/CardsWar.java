package org.vancina.cardswar;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("\nNumber of players? ");
        int numPlayers = kb.nextInt();
        System.out.print("Cards per hand? ");
        int handCards = kb.nextInt();

        int cardsNeeded = numPlayers * handCards;
        int packSize = Card.Suits.length * Card.Ranks.length;
        int packsNeeded = cardsNeeded / packSize;
        if (cardsNeeded % packSize > 0)
            packsNeeded+=1;

        System.out.printf("\nNeed %d cards, %d pack", cardsNeeded, packsNeeded);
        if (packsNeeded > 1) System.out.print("s");

        Shoe gameShoe = new Shoe(packsNeeded);
        //printCards(d);
        System.out.print("\n\nShuffling...");
        gameShoe.shuffle();
        //printCards(d);

        ArrayList<Hand> hands = new ArrayList<>();

        for (int x = 0; x<numPlayers; x++) {
            System.out.printf("\n\nDrawing player %d's hand...", x+1);
            Hand h = new Hand(handCards, gameShoe);
            h.sort();
            hands.add(h);
            printCards(h);
        }
        printHands(hands);

        System.out.println("\nCards remaining...");
        gameShoe.sort();
        if (printCards(gameShoe).length == 0)
            System.out.print("*** none ***");
    }

    private static void printHands(ArrayList<Hand> hands) {
        int numCards = hands.get(0).getCards().length;
        int numHands = hands.size();

        StringBuffer header = new StringBuffer();
        header.append("\n\n     ");
        for (int x = 0; x<numHands; x++)
            header.append(String.format("Player %d            ", x+1));

        System.out.println(header);
        for (int c = 0; c<numCards; c++) {
            System.out.printf("%3d) ", c+1);
            for (Hand hand : hands) {
                System.out.printf("%-20s", hand.getCards()[c]);
            }
            System.out.println();
        }
    }

    private static String[] printCards(Shoe s) {
        String [] c = s.getCards();
        for (int x = 0; x<c.length; x++)
            System.out.printf("\n%d) %s", x+1, c[x]);
        return c;
    }
}
