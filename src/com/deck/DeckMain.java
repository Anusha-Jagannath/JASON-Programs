package com.deck;

import java.util.ArrayList;

/*
 *  program to create a Player Object having Deck of Cards, and
 *  having ability to Sort by Rank and maintain the cards in a Queue implemented using
 *  Linked List. Finally Print the Player and the Cards received by each Player.
 */
public class DeckMain {

	public static void main(String[] args) {
		Player player[] = new Player[4];

		String suits[] = { "Clubs", "Daimonds", "Heart", "Spades" }; // array of suit
		String rank[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		String card[] = new String[52]; // Total cards

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				card[rank.length * i + j] = rank[j] + " of " + suits[i] + " |";
			}
		}

		// shuffle the cards
		String temp;
		for (int i = 0; i < card.length; i++) {
			int randomValue = (int) (Math.random() * card.length);
			for (int j = 0; j < card.length; j++) {
				temp = card[j];
				card[j] = card[randomValue];
				card[randomValue] = temp;
			}
		}

		ArrayList<Integer> cardList = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			System.out.println("\nPlayer " + (i + 1) + " cards:");
			player[i] = new Player();
			int j = 0;
			while (j < 9) {
				int randomValue = (int) (Math.random() * card.length);
				if (cardList.contains(randomValue) == false) {
					player[i].cards.add(card[randomValue]);
					cardList.add(randomValue);
					j++;
				}
			}
			player[i].cards.print();
			System.out.println();
		}
	}

}
