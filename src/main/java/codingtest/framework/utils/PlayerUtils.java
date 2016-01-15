package codingtest.framework.utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import codingtest.framework.domain.enums.Move;
import codingtest.framework.domain.player.Player;

/**
 * PlayerUtils contains various utility methods related to the Player domain.
 */
public class PlayerUtils {


  public static Player checkForBlackJack(List<Player> players){
    //check for black jack
    for (Player player : players) {
      if (player.getCardTotal() == 21){
        return player;
      }
    }
    return null;
  }

  public static List<Player> getPlayersWithStickStatus(List<Player> players) {
    List<Player> stickPlayers = new ArrayList<Player>();
    for (Player player : players) {
      if(player.getStatus().equals(Move.STICK)){
        stickPlayers.add(player);
      }
    }
    return stickPlayers;
  }

  public static boolean playersHaveSameTotals(List<Player> players) {
    HashSet<Integer> set = new HashSet<>();
    for (Player player : players) {
      set.add(player.getCardTotal());
    }
    return set.size() == 1;
  }

  public static boolean checkAllStick(List<Player> players){

    for (Player player : players) {
      if (player.getStatus().equals(Move.HIT)){
        return false;
      }
    }
    return true;
  }

  public static boolean checkAllBust(List<Player> players){
    for (Player player : players) {
      if (!player.getStatus().equals(Move.BUST)){
        return false;
      }
    }
    return true;
  }

  public static boolean checkOnePlayerLeft(List<Player> players){

    int numberOfPlayers = players.size();
    int bustPlayersCount = 0;
    for (Player player : players) {
      if (player.getStatus().equals(Move.BUST)) bustPlayersCount++;
    }
    return ((numberOfPlayers - bustPlayersCount) == 1);
  }

  public static boolean oneStickPlayerLeft(List<Player> stickPlayers) {
    return stickPlayers.size() == 1;
  }
}
