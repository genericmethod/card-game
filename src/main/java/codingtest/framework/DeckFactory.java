package codingtest.framework;

import codingtest.framework.domain.deck.BasicShuffledDeck;
import codingtest.framework.domain.deck.Deck;
import codingtest.framework.domain.deck.NoShuffleDeck;
import codingtest.framework.domain.enums.ShuffleStrategy;


/**
 * The {@link DeckFactory} builds a Deck of cards depending on the specified {@link ShuffleStrategy}
 */
public class DeckFactory {

  public static Deck buildDeck(ShuffleStrategy shuffleStrategy){

    Deck deck = null;
    switch (shuffleStrategy) {

      case BASIC_SHUFFLE:
        deck = new BasicShuffledDeck();
        break;

      case NO_SHUFFLE:
        deck = new NoShuffleDeck();
        break;

      default: new BasicShuffledDeck();
    }

    return deck;
  }
}
