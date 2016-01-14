package codingtest.framework.domain.player;

import java.util.HashSet;
import java.util.Set;

import codingtest.framework.domain.card.Card;
import codingtest.framework.domain.enums.Move;

/**
 * This class represent a player taking part in a game of cards.
 * A player is defined by a name and a set of cards also known as a hand.
 */
public class Player {

  private Set<Card> cards =  new HashSet<Card>();
  private String playerName;

  public Player() {
  }

  public Player(String playerName) {
    this.playerName = playerName;
  }

  /**
   * Adds a new {@link Card} to the player's hand
   * @param card The {@link Card} to be added to the player's hand
   */
  public void addCard(Card card){
    cards.add(card);
  }

  /**
   * Return the total value of the player's hand.
   * @return The total value of the player's hand.
   */
  public int getCardTotal(){
    int total = 0;
    for (Card card : cards) {
      total = total + card.getRank().getValue();
    }
    return total;
  }

  //TODO - Move this out - players should have different Player strategies.

  /**
   * Decides the players next move
   * @return The player's next move.
   */
  public Move getStatus() {
    int total = getCardTotal();
    if (total < 17) return Move.HIT;
    if (total > 21) return Move.BUST;
    if (total >=17) return Move.STICK;
    return null;
  }

  public Set<Card> getCards() {
    return cards;
  }

  public String getPlayerName() {
    return playerName;
  }

  public String getInfo() {
    return getPlayerName() + " Card Total : " + getCardTotal() + " Status " + getStatus().name();
  }
}
