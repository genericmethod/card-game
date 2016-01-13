package codingtest.domain;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {

  List<Card> cards;

  public Player() {
    cards = new ArrayList<Card>();
  }

  public void addCard(Card card){
    cards.add(card);
  }

  public int getCardTotal(){
    int total = 0;
    for (Card card : cards) {
      total = total + card.getRank().value;
    }
    return total;
  }

  public Move getStatus() {
    int total = getCardTotal();
    if (total < 17) return Move.HIT;
    if (total > 21) return Move.BUST;
    if (total >=17) return Move.STICK;
    return null;
  }

  public List<Card> getCards() {
    return cards;
  }

}
