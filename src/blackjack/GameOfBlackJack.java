package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfBlackJack {

	public void gameFlow() {
		Scanner kb = new Scanner(System.in);
		Dealer Bob = new Dealer();
		Player Eric = new Player();
		BlackJackRules rules = new BlackJackRules();
		int currentMoneyBet = 0;

		Bob.getCard();
		Bob.shuffleCard();
		do {
			if (Bob.getPlayDeck().size() < 20) {
				System.out.println("We are short on Cards getting a new one and shuffling");
				Bob.setPlayDeck(new ArrayList<>());
				Bob.getCard();
				Bob.shuffleCard();
			}

			currentMoneyBet = moneyBet(kb, Eric);

			for (int i = 0; i < 2; i++) {
				Eric.hit(Bob.Deal());
				Bob.hit(Bob.Deal());
			}

			System.out.println(Bob.preFlopPrinter());
			System.out.println(Eric);
			rules.printFirstHandValue(Bob.getDealerHand().get(0));
			rules.printPlayerHandValue(Eric.getPlayerHand());

			if (rules.blackJack(Eric.getPlayerHand())) {
				System.out.println("You have black Jack!!!");
			} else if (rules.blackJack(Bob.getDealerHand())) {
				System.out.println("Dealer has black Jack!!!");
			}

			playerTurn(Eric, rules, Bob, kb);

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

			if (rules.checkBusted(Eric.getPlayerHand())) {
			} else if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == 1) {
				System.out.println("player Win");
				Eric.setMoney(Eric.getMoney() + (currentMoneyBet * 2));
			} else if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == -1) {
				System.out.println("Dealer Win");
			} else if (rules.didPlayerWin(Eric.getPlayerHand(), Bob.getDealerHand()) == 0) {
				System.out.println("Push");
				Eric.setMoney(Eric.getMoney() + currentMoneyBet);
			}

			if (Eric.getMoney() == 0) {
				System.out.println("You have lost all your Money. Please stop gambling!!!");
				break;
			}

			Eric.setPlayerHand(new ArrayList<>());
			Bob.setDealerHand(new ArrayList<>());

		} while (playAgain(kb));

		System.out.println(Eric.getMoney());
		if (Eric.getMoney() == 0) {
			System.out.println("You have issues.....");
		} else if (Eric.getMoney() < 30) {
			System.out.println("Not good.... you lost most of the money. Now let's go to mcdonalds for a meal");
		} else if (Eric.getMoney() < 75) {
			System.out.println("Not bad.... you lost but quited before you got in too deep");
		} else if (Eric.getMoney() < 100) {
			System.out.println("You lost some money. great job.");
		} else if (Eric.getMoney() == 100) {
			System.out.println("Did you even gamble? Get in and play more!");
			gameFlow();
		} else if (Eric.getMoney() < 1000) {
			System.out.println("You are good at this! You should consider making a living off of this!");
		} else if (Eric.getMoney() < 10000) {
			System.out.println("Do you know how to count cards? Teach me!");
		}

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

	public int moneyBet(Scanner kb, Player Eric) {
		System.out.print("How much money do you want to bet???  [1 ~ " + Eric.getMoney() + "]: ");
		int a = kb.nextInt();
		Eric.setMoney(Eric.getMoney() - a);
		if (Eric.getMoney() < 0) {
			System.out.println("You have insufficiant funds, Please try again");
			Eric.setMoney(Eric.getMoney() + a);
			moneyBet(kb, Eric);

		} else {
			System.out.println("You betted: " + a + " and current balance is: " + Eric.getMoney());
		}
		return a;

	}

	public void playerTurn(Player Eric, BlackJackRules rules, Dealer Bob, Scanner kb) {
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
	}
}
