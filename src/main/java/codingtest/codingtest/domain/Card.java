package codingtest.domain;

import codingtest.codingtest.domain.Rank;
import codingtest.codingtest.domain.Suit;

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
}
