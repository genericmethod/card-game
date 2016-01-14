package codingtest.framework.domain.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import codingtest.framework.domain.card.Card;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public abstract class Deck implements Shuffable {

  Stack<Card> shuffledCards = new Stack<Card>();
  List<Card> unShuffledCards;

  public Deck (List<Card> unShuffledCards){
    this.unShuffledCards = unShuffledCards;
  }

  public abstract void shuffle();
  public List<Card> getUnshuffledCards(){
    return unShuffledCards;
  }

  public Card popCard() {
    return shuffledCards.pop();
  }
}
