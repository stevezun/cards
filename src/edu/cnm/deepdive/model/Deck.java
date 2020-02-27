package edu.cnm.deepdive.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The class encapsulates the deck method.
 */
public class Deck {

  private List<Card> cards;
  private List<Card> dealt;

  /**
   * The methods define cards and dealt with a list function and assigns a value of s and r.
   */
  public Deck() {
    cards = new ArrayList<>();
    dealt = new LinkedList<>();
    for (Suit s : Suit.values()) {
      for (Rank r : Rank.values()) {
        cards.add(new Card(s, r));
      }
    }
  }

  /**
   * Returns card instance value that shows that the cards have been dealt.
   * @return
   */
  public Card deal() {
    Card card = cards.isEmpty() ? null : cards.remove(0);
    if (card != null) {
      dealt.add(card);
    }
    return card;
  }

  /**
   * Initializes the shuffle method using a rng.
   * @param rng
   */
  public void shuffle(Random rng) {
    gather();
    Collections.shuffle(cards, rng);
  }

  private void gather() {
    cards.addAll(dealt);
    dealt.clear();
  }

  /**
   * Gives a return value that counts the remaining cards left in the deck.
   * @return
   */
  public int remaining() {
    return cards.size();
  }

  /**
   * Gives a return count using int of the size of the deck of cards that have been dealt.
   * @return
   */
  public int dealt() {
    return dealt.size();
  }

  @Override
  public String toString() {
    return cards.toString();
  }

  public void sort(boolean gather) {
    if(gather) {
      gather();
    }
    cards.sort((card1, card2) -> {
      int result = card1.getSuit().compareTo(card2.getSuit());
      if (result == 0) {
        result = card1.getRank().compareTo(card2.getRank());
      }
      return result;
    } );
  }

}
