package codingtest;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

import static org.junit.Assert.assertEquals;

/**
 * @author cfarrugia
 */
public class BlackJackTest {

  @Test
  public void testDealHand() throws Exception {

    List<Card> newPackOfCards = Card.getNewPackOfCards();
    Deck deck = new Deck();
    deck.shuffle(newPackOfCards);
    BlackJack blackJack = new BlackJack(deck);
    blackJack.addPlayer(new Player());
    blackJack.addPlayer(new Player());

    blackJack.dealHand();

    final List<Player> players = blackJack.getPlayers();
    for (Player player : players) {
      assertEquals(2, player.getCards().size());
    }

  }
}