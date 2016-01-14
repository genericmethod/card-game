package codingtest.framework;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import codingtest.framework.domain.player.Player;
import codingtest.framework.domain.deck.Deck;

/**
 * The abstract game class can be extended to play different types of card games
 * that involve a deck of cards and a set of players.
 */
public abstract class Game implements Playable{

  private static final Logger log = Logger.getLogger(Game.class);

  private List<Player> players = new ArrayList<Player>();
  protected Deck deck;

  public Game(Deck deck) {
    this.deck = deck;
  }

  /**
   * Every card game follows a standard seqeuence of events
   * 1. Deal first hand
   * 2. Start a round
   * 3. Each player executes turn
   * 4. Stop playing if game has finished
   */
  public void play() {

    init();
    while (isGameNotFinished()) {
      for (Player player : getPlayers()) {
        executeTurn(player);
      }
    }
    log.info("*** Game Finished");
  }

  /**
   * Perform any game initialisation ex.
   * handing out initial set of cards to Players.
   */
  protected abstract void init();

  /**
   * Implement each player's turn.
   * @param player {@link Player} that is currently playing.
   */
  protected abstract void executeTurn(Player player);
  protected abstract boolean isGameFinished();
  public abstract Player getWinner();
  private boolean isGameNotFinished() {
    return !isGameFinished();
  }

  /**
   * Add a player to the game
   * @param player {@link Player}
   */
  public void addPlayer(Player player) {
    players.add(player);
  }

  /**
   * Get a list of {@link Player taking part in the game}
   * @return List of {@link Player}
   */
  public List<Player> getPlayers() {
    return players;
  }


}
