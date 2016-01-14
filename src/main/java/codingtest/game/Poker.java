package codingtest.game;

import codingtest.framework.Game;
import codingtest.framework.domain.player.Player;
import codingtest.framework.domain.deck.Deck;

public class Poker extends Game {

  public Poker(Deck deck) {
    super(deck);
  }

  @Override
  protected void executeTurn(Player player) {
  }

  @Override
  protected void init() {}

  @Override
  protected boolean isGameFinished() {
    return false;
  }

  @Override
  public Player getWinner() {
    return null;
  }
}
