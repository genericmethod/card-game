package codingtest.domain.deck;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import codingtest.domain.Card;

/**
 * @author cfarrugia
 */
public class BasicShuffledDeck implements Deck {

  Stack<Card> shuffledCards = new Stack<Card>();

  public Card popCard() {
    return shuffledCards.pop();
  }

  public Stack<Card> shuffle(List<Card> unShuffledCards) {

    Collections.shuffle(unShuffledCards);
    for (Card unshuffledCard : unShuffledCards) {
      shuffledCards.push(unshuffledCard);
    }

    return shuffledCards;
  }
}
