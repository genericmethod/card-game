package codingtest.domain.deck;

import java.util.List;
import java.util.Stack;

import codingtest.domain.Card;


public interface Shuffable {
  Stack<Card> shuffle(List<Card> unShuffledCards);
}
