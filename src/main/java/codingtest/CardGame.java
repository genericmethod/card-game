package codingtest;

import java.util.List;

import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.domain.deck.Deck;

/**
 * Class that handles the playing of a card game from a simple command line interface,
 * and echoes back a step-by-step description of the game to the console.
 */
public class CardGame  {

    /**
     * Main. Plays a card game from a command line interface.
     * @param args the arguments to the game
     */
    public static void main(String[] args) {
        List<Card> newPackOfCards = Card.getNewPackOfCards();
        Deck deck = new Deck();
        deck.shuffle(newPackOfCards);
        BlackJack blackJack = new BlackJack(deck);
        blackJack.addPlayer(new Player());
        blackJack.addPlayer(new Player());
        blackJack.play();
    }
}
