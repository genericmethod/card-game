package codingtest.framework.domain.deck;

import java.util.Stack;

import codingtest.framework.domain.card.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public abstract class Deck implements Shuffable {

  Stack<Card> shuffledCards = new Stack<Card>();

  public Card popCard() {
    return shuffledCards.pop();
  }
}
