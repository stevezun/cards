package edu.cnm.deepdive.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Encapsulates a single playing card as a combination of {@link Suit} and {@link Rank}.Instances of this class are immutable.
 *
 * @author steve
 */
public class Card implements Comparable<Card>{

  private final Suit suit;
  private final Rank rank;
  private final int hash;

  /**
   * Initializes the card instance with the specified{@link Suit} and {@link Rank}
   * @param suit {@link Suit} value of card.
   * @param rank {@link Rank} value of card.
   */
  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
    hash = Objects.hash( suit, rank );
  }

  /**
   * Returns {@link Suit} of this Card instance.
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Returns {@link Rank} of this Card instance.
   */
  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int hashCode() {
    return hash;
  }

  @Override
  public boolean equals(Object obj) {

    boolean comparison = false;
    if (obj == this) {
      comparison = true;
    } else if (obj instanceof Card && obj.hashCode() == hash) {
      Card other = (Card) obj;
      if (suit == other.suit && rank == other.rank) {
        comparison = true;
      }
    }

    return comparison;
  }

  @Override
  public int compareTo(Card other) {
    return Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).compare(this, other);
  }

}


