package codingtest.framework.domain.deck;

import org.junit.Test;
import java.util.List;

import codingtest.framework.DeckFactory;
import codingtest.framework.domain.card.Card;
import codingtest.framework.domain.enums.ShuffleStrategy;

import static org.junit.Assert.assertEquals;

public class DeckTest {

  @Test
  public void testDeckShuffle() {
    List<Card> newPackOfCards = Card.getNewPackOfCards();
    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    assertEquals("Deck must still have 52 cards when shuffled",52, deck.shuffle(newPackOfCards).size());
  }
}