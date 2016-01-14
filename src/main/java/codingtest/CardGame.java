package codingtest;

import org.apache.log4j.Logger;

import java.util.Scanner;

import codingtest.framework.DeckFactory;
import codingtest.framework.Game;
import codingtest.framework.GameFactory;
import codingtest.framework.domain.deck.Deck;
import codingtest.framework.domain.enums.GameType;
import codingtest.framework.domain.enums.ShuffleStrategy;
import codingtest.framework.domain.player.Player;

/**
 * Class that handles the playing of a card game from a simple command line interface, and echoes
 * back a step-by-step description of the game to the console.
 */
public class CardGame {

  private static final Logger log = Logger.getLogger(CardGame.class);

  /**
   * Main. Plays a card game from a command line interface.
   *
   * @param args the arguments to the game
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    displayChooseCardDeckMenu();

    Integer deckSelection  = scanner.nextInt();

    Deck deck;
    switch (deckSelection) {
      case 1:
        deck = DeckFactory.buildDeck(ShuffleStrategy.NO_SHUFFLE);
        break;
      case 2:
        deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
        break;
      case 3:
        System.out.println("Goodbye!");
        return;
      default:
        System.out.println("Invalid selection");
        return;
    }

    selectCardGameMenu();

    Integer gameSelection  = scanner.nextInt();

    Game game;
    switch (gameSelection) {
      case 1:
        game = GameFactory.buildGame(GameType.BLACKJACK, deck);
        break;
      case 2:
        game = GameFactory.buildGame(GameType.POKER, deck);
        break;
      case 3:
        System.out.println("Goodbye!");
        return;
      default:
        System.out.println("Invalid selection");
        return;
    }

    System.out.println("Enter Number of Players: ");

    Integer numberOfPlayers = Integer.valueOf(scanner.next());

    if (numberOfPlayers < 1 || numberOfPlayers > 6) {
      System.out.print("Number of players must be between 1 & 6");
      return;
    }

    for (int i = 0; i < numberOfPlayers; i++) {
      game.addPlayer(new Player("Player " + (i + 1)));
    }

    game.play();

    log.info("Winner - " + (game.getWinner() == null ?
            "No Winner! " :
            game.getWinner().getPlayerName()));
  }

  public static void selectCardGameMenu() {
    System.out.println("============================");
    System.out.println("|   Select A Card Game     |");
    System.out.println("============================");
    System.out.println("| Options:                 |");
    System.out.println("|        1. Blackjack      |");
    System.out.println("|        2. Poker          |");
    System.out.println("|        3. Exit           |");
    System.out.println("============================");
  }

  public static void displayChooseCardDeckMenu() {
    System.out.println("============================");
    System.out.println("|   Choose a Card Deck     |");
    System.out.println("============================");
    System.out.println("| Options:                 |");
    System.out.println("|   1. UnShuffled Deck     |");
    System.out.println("|   2. Basic Shuffle       |");
    System.out.println("|   3. Exit                |");
    System.out.println("============================");
  }
}
