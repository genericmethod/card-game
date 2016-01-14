package codingtest.framework.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.framework.domain.card.Card;


public class NoShuffleDeck extends Deck {

  public Stack<Card> shuffle(List<Card> unshuffledCards) {
    for (Card unshuffledCard : unshuffledCards) {
      shuffledCards.push(unshuffledCard);
    }
    return shuffledCards;
  }
}
