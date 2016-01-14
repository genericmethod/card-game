package codingtest;

import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

public class Poker extends Game{

  public Poker(Deck deck) {
    super(deck);
  }

  @Override
  protected void executeTurn(Player player) {

  }

  @Override
  protected void dealHand() {

  }

  @Override
  protected boolean isGameFinished() {
    return false;
  }
}
