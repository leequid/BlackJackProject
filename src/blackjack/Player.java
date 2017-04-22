package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player extends TablePlayer {
	private List<Card> playerHand = new ArrayList<Card>();
	private List<List<Card>> games = new ArrayList<>();
	private int money;

	public void hit(Card a) {
		playerHand.add(a);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player hand is: ");
		for (Card card : playerHand) {
			builder.append(card +"  ");
		}
		return builder.toString();
	}

	
	public List<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}

	@Override
	public void stay() {
		// TODO Auto-generated method stub

	}
}
