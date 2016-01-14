package codingtest.framework;

import codingtest.framework.domain.card.Card;
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
        deck = new BasicShuffledDeck(Card.getNewPackOfCards());
        break;

      case NO_SHUFFLE:
        deck = new NoShuffleDeck(Card.getNewPackOfCards());
        break;

      default: new BasicShuffledDeck(Card.getNewPackOfCards());
    }

    return deck;
  }
}
