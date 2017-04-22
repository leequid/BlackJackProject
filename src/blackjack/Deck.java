package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(52);

	public Deck() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}



	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
	

}