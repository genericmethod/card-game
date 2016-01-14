package codingtest.framework.domain.card;

import java.util.ArrayList;
import java.util.List;

import codingtest.framework.domain.enums.Rank;
import codingtest.framework.domain.enums.Suit;

/**
 * This is the domain class that represents a card in a card game.
 */
public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns a new pack of cards orderes by Suit and Rank.
   * @return List of {@link Card}
   */
  public static List<Card> getNewPackOfCards() {
    ArrayList<Card> newPackOfCards = new ArrayList<Card>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        newPackOfCards.add(new Card(rank,suit));
      }
    }
    return newPackOfCards;
  }
}
