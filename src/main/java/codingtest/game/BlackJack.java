package codingtest.game;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import codingtest.framework.Game;
import codingtest.framework.domain.deck.Deck;
import codingtest.framework.domain.enums.Move;
import codingtest.framework.domain.player.Player;
import codingtest.framework.utils.PlayerUtils;

/**
 * Blackjack implementation of a {@link Game}
 */
public class BlackJack extends Game {

  private static final Logger log = Logger.getLogger(BlackJack.class);

  public BlackJack(Deck deck) {
    super(deck);
  }

  /**
   * In Blackjack, the game is initialised by giving players two cards from the deck.
   */
  public void init() {
    log.info("*** Dealing first hand to all players");
    for (Player player : getPlayers()) {
      //pop two cards for each player
      player.addCard(deck.dealCard());
      player.addCard(deck.dealCard());
      log.info(player.getInfo());
    }
    log.info("*** First hand dealt to all players");
  }

  /**
   * If the players turn is a HIT, give the player another card.
   *
   * @param player {@link Player} that is currently playing.
   */
  public void executeTurn(Player player) {
    if (player.getStatus() == Move.HIT) {
      player.addCard(deck.dealCard());
    }
    log.info(player.getInfo());
  }

  /**
   * Returns the winning {@link Player} based on a set of rules.
   * @return The winning {@link Player}
   */
  public Player getWinner() {

    List<Player> stickPlayers = PlayerUtils.getPlayersWithStickStatus(getPlayers());
    if (stickPlayers.size() == 0) return null;

    final Player player = PlayerUtils.checkForBlackJack(stickPlayers);
    if (player != null) return player;

    if (PlayerUtils.oneStickPlayerLeft(stickPlayers)) return stickPlayers.get(0);

    if (PlayerUtils.playersHaveSameTotals(stickPlayers)) {
      return null;
    }

    return Collections.max(stickPlayers, new Comparator<Player>() {
      public int compare(Player o1, Player o2) {
        return Integer.compare(o1.getCardTotal(), o2.getCardTotal());
      }
    });
  }

  public boolean isGameFinished() {
    return PlayerUtils.checkForBlackJack(getPlayers()) != null ||
            PlayerUtils.checkOnePlayerLeft(getPlayers()) ||
            PlayerUtils.checkAllStick(getPlayers()) ||
            PlayerUtils.checkAllBust(getPlayers());
  }

}
