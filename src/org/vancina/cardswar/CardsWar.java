package org.vancina.cardswar;

class Main {

    public static void main(String[] args) {
	// write your code here
        Deck d = new Deck(1);
        printCards(d);
        System.out.println("\nShuffling...");
        d.shuffle();
        printCards(d);

        Hand h;
        System.out.println("\nDrawing a hand...");
        h = new Hand(7, d);
        h.sort();
        printCards(h);

        System.out.println("\nDrawing a hand...");
        h = new Hand(7, d);
        h.sort();
        printCards(h);

        System.out.println("\nDrawing a hand...");
        h = new Hand(7, d);
        h.sort();
        printCards(h);

        System.out.println("\nDrawing a hand...");
        h = new Hand(7, d);
        h.sort();
        printCards(h);

        System.out.println("\nCards remaining...");
        d.sort();
        printCards(d);
    }

    private static void printCards(Deck d) {
        String [] c = d.getCards();
        for (int x = 0; x<c.length; x++)
            System.out.printf("%d) %s\n", x+1, c[x]);
    }
}
