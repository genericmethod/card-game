package codingtest.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.domain.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public interface Deck {
  Card popCard();
  Stack<Card> shuffle(List<Card> unShuffledCards);
}
