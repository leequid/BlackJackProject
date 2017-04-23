package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player extends TablePlayer {
	private List<Card> playerHand = new ArrayList<Card>();
	private List<List<Card>> games = new ArrayList<>();
	private int money = 100;

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

	public List<List<Card>> getGames() {
		return games;
	}

	public void setGames(List<List<Card>> games) {
		this.games = games;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
