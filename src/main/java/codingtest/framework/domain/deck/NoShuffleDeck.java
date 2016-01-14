package codingtest.framework.domain.deck;

import java.util.List;

import codingtest.framework.domain.card.Card;

/**
 * This class represents a shuffled deck of cards that has not been shuffled.
 * The shuffle method simply pushes unshuffled cards to the stack in their original order.
 */
public class NoShuffleDeck extends Deck {

  public NoShuffleDeck(List<Card> unShuffledCards) {
    super(unShuffledCards);
  }

  public void shuffle() {
    for (Card unShuffledCard : getUnShuffledCards()) {
      getShuffledCards().push(unShuffledCard);
    }
  }
}
