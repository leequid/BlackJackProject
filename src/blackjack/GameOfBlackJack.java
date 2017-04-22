package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfBlackJack {

	public void gameFlow() {
		Scanner kb = new Scanner(System.in);
		Dealer Bob = new Dealer();
		Player Eric = new Player();
		BlackJackRules rules = new BlackJackRules();

		Bob.getCard();
		Bob.shuffleCard();
		do{
			if (Bob.getPlayDeck().size() < 20) {
				System.out.println("We are short on Cards getting a new one and shuffling");
				Bob.setPlayDeck(new ArrayList<>());
				Bob.getCard();
				Bob.shuffleCard();
			}

			for (int i = 0; i < 2; i++) {
				Eric.hit(Bob.Deal());
				Bob.hit(Bob.Deal());
			}

			System.out.println(Bob.preFlopPrinter());
			System.out.println(Eric);

			if (rules.blackJack(Eric.getPlayerHand())) {
				System.out.println("You have black Jack!!!");
			} else if (rules.blackJack(Bob.getDealerHand())) {
				System.out.println("Dealer has black Jack!!!");
			} else {
				rules.printPlayerHandValue(Eric.getPlayerHand());
			}

			while (!(rules.checkBusted(Eric.getPlayerHand())) && !(rules.blackJack(Eric.getPlayerHand()))) {
				System.out.println("What would you Like to do?");
				System.out.println("1. Hit");
				System.out.println("2. Stay");
				int select = kb.nextInt();

				switch (select) {
				case 1:

					Eric.hit(Bob.Deal());
					System.out.println(Eric);
					rules.printPlayerHandValue(Eric.getPlayerHand());

					break;
				case 2:
					break;

				}
				if (rules.checkBusted(Eric.getPlayerHand())) {
					System.out.println("You are busted!!!");
					break;
				}
				if (select == 2) {
					break;
				}

			}
			System.out.println(Bob);
			rules.printDealerHandValue(Bob.getDealerHand());

			while (!(rules.checkBusted(Bob.getDealerHand())) && !(rules.blackJack(Bob.getDealerHand()))) {
				if (rules.DealerShouldHit(Bob.getDealerHand())) {
					Bob.hit(Bob.Deal());
					System.out.println(Bob);
					rules.printDealerHandValue(Bob.getDealerHand());
				} else {
					break;

				}

			}

			if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == 1) {
				System.out.println("player Win");
			} else if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == -1) {
				System.out.println("Dealer Win");
			}
			if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == 0) {
				System.out.println("Push");
			}
			
			Eric.setPlayerHand(new ArrayList<>());
			Bob.setDealerHand(new ArrayList<>());

		}while (playAgain(kb)) ;

	}

	public boolean playAgain(Scanner kb) {

		System.out.println("Would you like to play again? (1 for YES and 2 for NO)");
		int again = Integer.parseInt(kb.next());
		if (again == 2) {
			return false;
		} else if (again == 1) {
			System.out.println("Let's get the next round started!!!");
			System.out.println("*************************************");
			return true;
		} else {
			System.out.println("You want to play or not?");
			playAgain(kb);
			return false;
		}

	}

	public void playerTurn(Player b) {

	}
}
