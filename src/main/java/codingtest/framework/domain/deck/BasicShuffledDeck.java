package codingtest.framework.domain.deck;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import codingtest.framework.domain.card.Card;

public class BasicShuffledDeck extends Deck {

  public Stack<Card> shuffle(List<Card> unShuffledCards) {

    Collections.shuffle(unShuffledCards);
    for (Card unShuffledCard : unShuffledCards) {
      shuffledCards.push(unShuffledCard);
    }

    return shuffledCards;
  }
}
