package codingtest.domain;


import java.util.ArrayList;
import java.util.List;

public class Player {
  Move nextMove;
  List<Card> cards = new ArrayList<Card>();

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
}
