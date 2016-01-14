package codingtest.domain.deck;

import codingtest.domain.enums.ShuffleStrategy;

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
