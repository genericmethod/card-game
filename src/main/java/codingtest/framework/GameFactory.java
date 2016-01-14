package codingtest.framework;

import codingtest.framework.domain.deck.BasicShuffledDeck;
import codingtest.framework.domain.deck.Deck;
import codingtest.framework.domain.enums.GameType;


/**
 * The {@link GameFactory} builds a Game depending on the specified {@link GameType}
 */
public class GameFactory {

  public static Game buildGame(GameType gameType, Deck deck){

    Game game = null;
    switch (gameType) {

      case BLACKJACK:
        game = new BlackJack(deck);
        break;

      case POKER:
        game = new Poker(deck);
        break;

      default: new BlackJack(deck);
    }
    return game;
  }
}
