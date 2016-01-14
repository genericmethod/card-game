package codingtest.framework.domain.deck;

import java.util.Collections;
import java.util.List;

import codingtest.framework.domain.card.Card;

/**
 * This class represents a shuffled deck of cards that is shuffled
 * using  {@link java.util.Collections#shuffle shuffle} method.x
 */
public class BasicShuffledDeck extends Deck {

  public BasicShuffledDeck(List<Card> unShuffledCards) {
    super(unShuffledCards);
  }

  public void shuffle() {
    Collections.shuffle(getUnShuffledCards());
    for (Card unShuffledCard : getUnShuffledCards()) {
      getShuffledCards().push(unShuffledCard);
    }
  }
}
