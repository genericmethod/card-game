package codingtest.framework.domain.deck;

import java.util.List;

import codingtest.framework.domain.card.Card;


public class NoShuffleDeck extends Deck {

  public NoShuffleDeck(List<Card> unShuffledCards) {
    super(unShuffledCards);
  }

  public void shuffle() {
    for (Card unShuffledCard : unShuffledCards) {
      shuffledCards.push(unShuffledCard);
    }
  }
}
