package codingtest.domain.deck;

import java.util.List;

import codingtest.domain.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck extends BasicShuffleStrategy {

  public Card popCard(){
    return shuffledCards.pop();
  }
}
