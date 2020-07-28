package effectivejava.chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEM, JACK, QUEEN, KING }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit + "S";
    }
    private static final List<Card> NEW_DECK = newDeck();

    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    private static final List<Card> NEW_DECK2 = newDeck2();

    

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
        System.out.println(NEW_DECK2);
    }

    private static List<Card> newDeck2() {

        return Stream.of(Suit.values())
                .flatMap(suit -> 
                        Stream.of(Rank.values())
                            .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }
}