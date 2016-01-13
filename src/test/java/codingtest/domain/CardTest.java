package codingtest.domain;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CardTest {

  @Test
  public void testGetNewPack(){
    final List<Card> newPackOfCards = Card.getNewPackOfCards();
    assertEquals(52, newPackOfCards.size());
  }

}