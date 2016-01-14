package codingtest.framework.domain;

import org.junit.Test;

import codingtest.framework.domain.card.Card;
import codingtest.framework.domain.enums.Move;
import codingtest.framework.domain.enums.Rank;
import codingtest.framework.domain.enums.Suit;
import codingtest.framework.domain.player.Player;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

  @Test
  public void testGetCardTotal() throws Exception {

    Player player = new Player();

    assertEquals(0, player.getCardTotal());
    assertEquals(Move.HIT, player.getStatus());

    player.addCard(new Card(Rank.ACE, Suit.CLUBS));
    assertEquals(11, player.getCardTotal());
    assertEquals(Move.HIT, player.getStatus());

    player.addCard(new Card(Rank.EIGHT, Suit.CLUBS));
    assertEquals(19, player.getCardTotal());
    assertEquals(Move.STICK, player.getStatus());

    player.addCard(new Card(Rank.THREE, Suit.CLUBS));
    assertEquals(22, player.getCardTotal());
    assertEquals(Move.BUST, player.getStatus());
  }
}