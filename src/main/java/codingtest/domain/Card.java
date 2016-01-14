package codingtest.domain;

import java.util.ArrayList;
import java.util.List;

import codingtest.domain.enums.Rank;
import codingtest.domain.enums.Suit;

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
