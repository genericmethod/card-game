package codingtest;

import java.util.List;

import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

public class BlackJack extends Game {

  private Deck deck;

  public BlackJack(Deck deck) {
    this.deck = deck;
  }

  public void play() {
    dealHand();
  }

  public void dealHand() {
    for (Player player : getPlayers()) {
      //pop two cards for each player
      player.addCard(deck.popCard());
      player.addCard(deck.popCard());
    }
  }

  private boolean isGameFinished(){
    final List<Player> players = getPlayers();
    for (Player player : players) {

    }
    return true;
  }
}
