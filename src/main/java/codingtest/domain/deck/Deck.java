package codingtest.domain.deck;

import java.util.Stack;

import codingtest.domain.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public abstract class Deck implements Shuffable {

  Stack<Card> shuffledCards = new Stack<Card>();

  public Card popCard() {
    return shuffledCards.pop();
  }
}
