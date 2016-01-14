package codingtest;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.domain.deck.Deck;
import codingtest.domain.deck.DeckFactory;
import codingtest.domain.enums.ShuffleStrategy;

/**
 * Class that handles the playing of a card game from a simple command line interface,
 * and echoes back a step-by-step description of the game to the console.
 */
public class CardGame  {

    private static final Logger log = Logger.getLogger(CardGame.class);

    /**
     * Main. Plays a card game from a command line interface.
     * @param args the arguments to the game
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Players: ");

        Integer numberOfPlayers = Integer.valueOf(scanner.next());

        if (numberOfPlayers < 1 || numberOfPlayers > 6){
            System.out.print("Number of players must be between 1 & 6");
            return;
        }

        List<Card> newPackOfCards = Card.getNewPackOfCards();
        Deck deck = DeckFactory.buildDeck(ShuffleStrategy.BASIC_SHUFFLE);
        deck.shuffle(newPackOfCards);
        BlackJack blackJack = new BlackJack(deck);

        for (int i = 0; i < numberOfPlayers ; i++) {
            blackJack.addPlayer(new Player("Player " + (i + 1)));
        }

        blackJack.play();

        log.info("Winner - " + (blackJack.getWinner() == null ? "No Winner! " : blackJack.getWinner().getPlayerName()));


    }
}
