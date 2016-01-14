package codingtest.framework.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.framework.domain.card.Card;


public interface Shuffable {
  Stack<Card> shuffle(List<Card> unShuffledCards);
}
