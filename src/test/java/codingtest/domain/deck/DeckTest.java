package codingtest.domain.deck;

import org.junit.Test;
import java.util.List;

import codingtest.domain.Card;
import static org.junit.Assert.assertEquals;

public class DeckTest {

  @Test
  public void testDeckShuffle() {
    List<Card> newPackOfCards = Card.getNewPackOfCards();
    Deck deck = new Deck();
    assertEquals("Deck must still have 52 cards when shuffled",52, deck.shuffle(newPackOfCards).size());
  }
}