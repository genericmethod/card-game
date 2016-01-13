package codingtest;



import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import codingtest.domain.Move;
import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

public class BlackJack extends Game {

  private static final Logger log = Logger.getLogger(BlackJack.class);

  private Deck deck;

  public BlackJack(Deck deck) {
    this.deck = deck;
  }

  public void play() {
    log.info("*** Game Started");
    dealHand();

    log.info("*** First hand dealt");
    while (isGameNotFinished()) {
      for (Player player : getPlayers()) {
        executeTurn(player);
      }
    }
    log.info("*** Game Finished");
  }

  public void dealHand() {
    for (Player player : getPlayers()) {
      //pop two cards for each player
      player.addCard(deck.popCard());
      player.addCard(deck.popCard());
    }
  }

  public void executeTurn(Player player){
    log.info("**** Executing Turn ...");
    if (player.getStatus() == Move.HIT) {
      player.addCard(deck.popCard());
    }
    log.info(player.getInfo());
  }

  public Player getWinner(List<Player> players) {

    List<Player> stickPlayers = getPlayersWithStickStatus(players);

    final Player player = checkForBlackJack(stickPlayers);
    if (player != null) return player;

    if(playersHaveSameTotals(stickPlayers)){
      return null;
    }

    return Collections.max(stickPlayers, new Comparator<Player>() {
      public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getCardTotal(),o2.getCardTotal());
      }
    });
  }

  private List<Player> getPlayersWithStickStatus(List<Player> players) {
    List<Player> stickPlayers = new ArrayList<Player>();
    for (Player player : players) {
      if(player.getStatus().equals(Move.STICK)){
        stickPlayers.add(player);
      }
    }
    return stickPlayers;
  }

  private boolean playersHaveSameTotals(List<Player> players) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (Player player : players) {
      set.add(player.getCardTotal());
    }
    return set.size() == 1;
  }

  public boolean isGameFinished(){
    return checkForBlackJack(getPlayers()) != null ||
            checkOnePlayerLeft(getPlayers()) ||
            checkAllStick(getPlayers());
  }

  private boolean isGameNotFinished(){
    return !isGameFinished();
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

  private Player checkForBlackJack(List<Player> players){
    //check for black jack
    for (Player player : players) {
      if (player.getCardTotal() == 21){
        return player;
      }
    }
    return null;
  }
}
