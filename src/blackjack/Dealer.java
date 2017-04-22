package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer extends TablePlayer {
	private List<Card> playDeck = new ArrayList<Card>();
	private List<Card> dealerHand = new ArrayList<Card>();

	public void getCard() {
		Deck openedCardDeck = new Deck();
		playDeck.addAll(openedCardDeck.getDeck());

	}

	public void shuffleCard() {
		Collections.shuffle(playDeck);
	}

	public Card Deal() {
		return playDeck.remove(0);
	}

	public void hit(Card a) {
		dealerHand.add(a);
	}

	public void stay() {

	}

	public String preFlopPrinter() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand is: ");
		builder.append(dealerHand.get(0));
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand is: ");
		for (Card card : dealerHand) {
			builder.append(card +"  ");
		}

		return builder.toString();
	}

	public List<Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(List<Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public List<Card> getPlayDeck() {
		return playDeck;
	}

	public void setPlayDeck(List<Card> playDeck) {
		this.playDeck = playDeck;
	}
	

}
