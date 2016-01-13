package codingtest;

import java.util.List;

import codingtest.domain.Move;
import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

public class BlackJack extends Game {

  private Deck deck;

  public BlackJack(Deck deck) {
    this.deck = deck;
  }

  public void play() {
    dealHand();
    while (isGameNotFinished()){
      //nextTurn();
    }

  }

  public void dealHand() {
    for (Player player : getPlayers()) {
      //pop two cards for each player
      player.addCard(deck.popCard());
      player.addCard(deck.popCard());
    }

//    while (isGameNotFinished()) {
//      for (Player player : getPlayers()) {
//        executeTurn(player);
//      }
//
//    }
  }

  public boolean isGameFinished(){
    return checkForBlackJack(getPlayers()) ||
            checkOnePlayerLeft(getPlayers()) ||
            checkAllStick(getPlayers());
  }

  private boolean isGameNotFinished(){
    return !isGameFinished();
  }

  public void executeTurn(Player player){
    if (player.getStatus() == Move.HIT) {
      player.addCard(deck.popCard());
      return;
    }
  }

  private boolean checkAllStick(List<Player> players){
    boolean allStick = true;
    for (Player player : players) {
      if (!player.getStatus().equals(Move.STICK)){
        return false;
      }
    }
    return true;
  }

  private boolean checkOnePlayerLeft(List<Player> players){

    int numberOfPlayers = players.size();
    int bustPlayersCount = 0;
    for (Player player : players) {
      if (player.getStatus().equals(Move.BUST)) bustPlayersCount++;
    }

    return ((numberOfPlayers - bustPlayersCount) == 1);
  }

  private boolean checkForBlackJack(List<Player> players){
    //check for black jack
    for (Player player : players) {
      if (player.getCardTotal() == 21){
        return true;
      }
    }

    return false;
  }
}
