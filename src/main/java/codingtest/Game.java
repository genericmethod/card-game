package codingtest;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import codingtest.domain.Player;

public abstract class Game {

  private static final Logger log = Logger.getLogger(Game.class);

  private List<Player> players = new ArrayList<Player>();

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

  protected abstract void executeTurn(Player player);
  protected abstract void dealHand();
  protected abstract boolean isGameFinished();
  private boolean isGameNotFinished(){
    return !isGameFinished();
  }

  void addPlayer(Player player){
    players.add(player);
  };

  public List<Player> getPlayers() {
    return players;
  }


}
