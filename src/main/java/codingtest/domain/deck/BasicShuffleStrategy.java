package codingtest.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.domain.Card;


public class BasicShuffleStrategy implements Shuffle {

  Stack<Card> shuffledCards = new Stack<Card>();

  public Stack<Card> shuffle(List<Card> unshuffledCards) {
    for (Card unshuffledCard : unshuffledCards) {
      shuffledCards.push(unshuffledCard);
    }
    return shuffledCards;
  }
}
