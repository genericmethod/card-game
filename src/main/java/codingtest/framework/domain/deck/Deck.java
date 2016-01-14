package codingtest.framework.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.framework.domain.card.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 * Create your own type of shuffled {@link Deck} by implementing this abstract class.
 */
public abstract class Deck implements Shuffable {

  Stack<Card> shuffledCards = new Stack<Card>();
  List<Card> unShuffledCards;

  public Deck (List<Card> unShuffledCards){
    this.unShuffledCards = unShuffledCards;
    shuffle();
  }

  /**
   * Implement the shuffle method to implement your custom shuffle strategy.
   */
  public abstract void shuffle();

  public List<Card> getUnShuffledCards(){
    return unShuffledCards;
  }

  /**
   * Pops a card from the top af the stack.
   * @return {@link Card} that has been taken from the top of the deck
   */
  public Card dealCard() {
    return shuffledCards.pop();
  }
}
