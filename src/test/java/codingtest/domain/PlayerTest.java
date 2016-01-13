package codingtest.domain;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

  @Test
  public void testGetCardTotal() throws Exception {

    Player player = new Player();

    assertEquals(0, player.getCardTotal());

    player.addCard(new Card(Rank.ACE, Suit.CLUBS));
    assertEquals(11, player.getCardTotal());

    player.addCard(new Card(Rank.EIGHT, Suit.CLUBS));
    assertEquals(19, player.getCardTotal());

  }
}