package blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackRules {

	public int[] CardValueHand(List<Card> hand) {
		int handValue1 = 0;
		int numOfAces = 0;
		int[] alternateValue = new int[3];

		for (Card card : hand) {
			if (((card.getRank().ordinal()) == 12)) {
				if (numOfAces == 0) {
					handValue1 += 11;
				} else if (numOfAces > 0) {
					handValue1 += 1;
				}
				numOfAces++;

			} else if (((card.getRank().ordinal() + 2) >= 10)) {
				handValue1 += 10;
			} else {
				handValue1 += card.getRank().ordinal() + 2;
			}
		}

		alternateValue[0] = handValue1;
		alternateValue[2] = numOfAces;

		if (numOfAces > 0) {
			alternateValue[1] = handValue1 - 10;
		} else {
			alternateValue[1] = handValue1;
		}

		return alternateValue;
	}

	public void printPlayerHandValue(List<Card> hand) {
		int[] currentHandValue = CardValueHand(hand);
		if (currentHandValue[0] == 21 || currentHandValue[1] == 21) {
			System.out.println("You got 21!!!");
		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] > 21)) {
			System.out.println("You are busted");
		} else if (currentHandValue[0] == currentHandValue[1]) {
			System.out.println("Your Current hand value is: " + currentHandValue[0]);

		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] < 21)) {
			System.out.println("Your Current hand value is: " + currentHandValue[1]);

		} else if ((currentHandValue[0] < 21) && (currentHandValue[1] > 21)) {
			System.out.println("Your Current hand value is: " + currentHandValue[0]);

		} else if ((currentHandValue[0] != currentHandValue[1])) {
			System.out.println("Your Current hand value is: " + currentHandValue[1] + "or" + currentHandValue[0]);

		}

	}

	public void printDealerHandValue(List<Card> hand) {
		int[] currentHandValue = CardValueHand(hand);
		if (currentHandValue[0] == 21 || currentHandValue[1] == 21) {
			System.out.println("Dealer got 21!!!");
		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] > 21)) {
			System.out.println("Dealer is busted");
		} else if (currentHandValue[0] == currentHandValue[1]) {
			System.out.println("Dealer's Current hand value is: " + currentHandValue[0]);

		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] < 21)) {
			System.out.println("Dealer's Current hand value is: " + currentHandValue[1]);

		} else if ((currentHandValue[0] < 21) && (currentHandValue[1] > 21)) {
			System.out.println("Dealer's Current hand value is: " + currentHandValue[0]);

		} else if ((currentHandValue[0] != currentHandValue[1])) {
			System.out.println("Dealer's Current hand value is: " + currentHandValue[1] + "or" + currentHandValue[0]);

		}

	}

	public void printFirstHandValue(Card hand) {
		List<Card> a = new ArrayList<Card>();
		a.add(hand);
		System.out.println("Dealer's faced up hand value is: " + CardValueHand(a)[0]);

	}

	public int finalCardValue(List<Card> hand) {
		int[] currentHandValue = CardValueHand(hand);
		if (currentHandValue[0] == 21 || currentHandValue[1] == 21) {
			return 21;
		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] > 21)) {
			return 0;
		} else if (currentHandValue[0] == currentHandValue[1]) {
			return currentHandValue[0];
		} else if ((currentHandValue[0] < 21) && (currentHandValue[1] > 21)) {
			return currentHandValue[0];
		} else if ((currentHandValue[0] > 21) && (currentHandValue[1] < 21)) {
			return currentHandValue[1];
		} else if ((currentHandValue[0] != currentHandValue[1])) {
			return currentHandValue[1];
		}
		return 0;
	}

	public int didPlayerWin(List<Card> playerHand, List<Card> dealerHand) {
		if (finalCardValue(playerHand) > finalCardValue(dealerHand)) {
			return 1;
		} else if (finalCardValue(playerHand) < finalCardValue(dealerHand)) {
			return -1;
		} else {
			return 0;
		}
	}

	public boolean checkBusted(List<Card> hand) {
		int[] cardValueTotal;
		cardValueTotal = CardValueHand(hand);

		if (cardValueTotal[0] > 21 && cardValueTotal[1] > 21) {
			return true;
		}

		return false;
	}

	public boolean blackJack(List<Card> hand) {
		int[] twentyOne;
		twentyOne = CardValueHand(hand);

		if (twentyOne[0] == 21) {
			return true;
		} else {
			return false;
		}

	}

	public boolean canYouSplit(List<Card> hand) {
		if (hand.get(0).getRank().ordinal() == hand.get(1).getRank().ordinal()) {
			return true;
		}
		return false;
	}

	public boolean DealerShouldHit(List<Card> DealerHand) {

		if ((CardValueHand(DealerHand)[0] == 17) && (CardValueHand(DealerHand)[2] > 0)) {
			return true;
		} else if (CardValueHand(DealerHand)[0] > 17 && CardValueHand(DealerHand)[0] <= 21) {
			return false;
		} else if (CardValueHand(DealerHand)[1] > 17 && CardValueHand(DealerHand)[1] <= 21) {
			return false;
		} else if (CardValueHand(DealerHand)[0] < 17 || CardValueHand(DealerHand)[1] < 17) {
			return true;
		} else {
			return false;
		}

	}

}
