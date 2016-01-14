package codingtest.domain.deck;

import org.junit.Test;
import java.util.List;

import codingtest.domain.Card;
import codingtest.domain.enums.ShuffleStrategy;

import static org.junit.Assert.assertEquals;

public class DeckTest {

  @Test
  public void testDeckShuffle() {
    List<Card> newPackOfCards = Card.getNewPackOfCards();
    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    assertEquals("Deck must still have 52 cards when shuffled",52, deck.shuffle(newPackOfCards).size());
  }
}