package codingtest;

import org.junit.Test;

import java.util.List;

import codingtest.game.BlackJack;
import codingtest.framework.domain.card.Card;
import codingtest.framework.domain.player.Player;
import codingtest.framework.DeckFactory;
import codingtest.framework.domain.enums.Rank;
import codingtest.framework.domain.enums.ShuffleStrategy;
import codingtest.framework.domain.enums.Suit;
import codingtest.framework.domain.deck.Deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlackJackTest {

  @Test
  public void testDealHand() throws Exception {

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);
    blackJack.addPlayer(new Player());
    blackJack.addPlayer(new Player());

    blackJack.init();

    final List<Player> players = blackJack.getPlayers();
    for (Player player : players) {
      assertEquals(2, player.getCards().size());
    }

  }

  @Test
  public void testIsGameFinishedAllPlayerStick(){

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    assertTrue("All players stick, game should be finished", blackJack.isGameFinished());

  }

  @Test
  public void testIsGameFinishedAllPlayerStickButOnePlayerIsBust(){

    Player playerOne = new Player();
    Player playerTwo = new Player();
    Player playerThree = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);
    blackJack.addPlayer(playerThree);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

    playerThree.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerThree.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    assertTrue("All players stick, game should be finished", blackJack.isGameFinished());

  }

  @Test
  public void testIsGameFinishedAllPlayersBust(){

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    assertTrue("All players bust, game should be finished", blackJack.isGameFinished());

  }

  @Test
   public void testIsGameFinishedPlayerHasBlackJackCombination(){

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.TWO, Suit.DIAMONDS));

    assertTrue("Game should be since a player has a blackjack combination", blackJack.isGameFinished());

  }

  @Test
  public void testIsGameFinishedAllGoneBustExceptOne(){

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.ACE, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.TWO, Suit.DIAMONDS));

    assertTrue("Game should be finished since one player has gone bust, which leaves a single player",
            blackJack.isGameFinished());

  }

  @Test
  public void testCheckWinnerBlackJack(){

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.TWO, Suit.DIAMONDS));

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    assertEquals(playerOne, blackJack.getWinner());
  }

  @Test
  public void testCheckWinnerHighestCard() {

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    assertEquals(playerTwo, blackJack.getWinner());
  }

  @Test
     public void testCheckWinnerOneBustOneStick() {

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.KING, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.THREE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    assertEquals(playerOne, blackJack.getWinner());
  }

  @Test
  public void testCheckWinnerTwoBust() {

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.THREE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.THREE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.NINE, Suit.DIAMONDS));

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);

    assertEquals(null, blackJack.getWinner());
  }

  @Test
  public void testCheckWinnerSameTotal() {

    Player playerOne = new Player();
    Player playerTwo = new Player();
    Player playerThree = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    playerThree.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerThree.addCard(new Card(Rank.KING, Suit.DIAMONDS));
    playerThree.addCard(new Card(Rank.KING, Suit.DIAMONDS));

    blackJack.addPlayer(playerOne);
    blackJack.addPlayer(playerTwo);
    blackJack.addPlayer(playerThree);

    assertEquals(null, blackJack.getWinner());

  }

  @Test
  public void testExecuteTurn() {

    Player playerOne = new Player();
    Player playerTwo = new Player();

    Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
    BlackJack blackJack = new BlackJack(deck);

    playerOne.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerOne.addCard(new Card(Rank.TWO, Suit.DIAMONDS));

    playerTwo.addCard(new Card(Rank.ACE, Suit.CLUBS));
    playerTwo.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

    blackJack.executeTurn(playerOne);
    blackJack.executeTurn(playerTwo);

    assertEquals("Player one status should be hit. Another card should be dealt", 3, playerOne.getCards().size());
    assertEquals("Player two status should be Stick. No card should be dealt", 2, playerTwo.getCards().size());
  }

}