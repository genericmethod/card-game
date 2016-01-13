package codingtest.domain;


import java.util.List;

public class Player {
  Move nextMove;
  List<Card> cards;

  public void addCard(Card card){
    cards.add(card);
  }
}
