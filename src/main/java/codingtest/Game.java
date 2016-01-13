package codingtest;

import java.util.ArrayList;
import java.util.List;
import codingtest.domain.Player;

public abstract class Game {

  private List<Player> players = new ArrayList<Player>();

  void addPlayer(Player player){
    players.add(player);
  };


  abstract void play();
}
