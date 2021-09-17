package com.deck;

/*
 *  DeckOfCards.java, to initialize deck of cards having suit & Rank. 
 *  Shuffle the cards using Random method and then
 *  distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players
 *  using 2D Array...
 */
public class DeckOfCards {

	public static void main(String[] args) {
		System.out.println("Welcome to card shuffle program");
		int i, j, k = 0;
		String suits[] = { "club", "spade", "diamond", "heart" };
		String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String deck[] = new String[52];
		String player[][] = new String[4][9];

		// initialize deck
		int n = suits.length * rank.length;
		for (i = 0; i < rank.length; i++) {
			for (j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = rank[i] + " of " + suits[j];
			}
		}

		// shuffle using swapping and random function
		for (i = 0; i < 52; i++) {
			int value = i + (int) (Math.random() * (52 - i));
			String temp = deck[value];
			deck[value] = deck[i];
			deck[i] = temp;
		}

		// providing shuffled cards to 4 players
		for (i = 0; i < 4; i++) {
			System.out.print("Player " + (i + 1) + " ");
			for (j = 0; j < 9; j++) {
				player[i][j] = deck[k++];
				System.out.print(player[i][j] + " | ");
			}
			System.out.println();
		}
	}

}
