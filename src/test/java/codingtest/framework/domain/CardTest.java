package codingtest.framework.domain;
import org.junit.Test;
import java.util.List;

import codingtest.framework.domain.card.Card;

import static org.junit.Assert.assertEquals;


public class CardTest {

  @Test
  public void testGetNewPack(){
    final List<Card> newPackOfCards = Card.getNewPackOfCards();
    assertEquals(52, newPackOfCards.size());
  }

}