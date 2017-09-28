/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Been Touched
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private String[] symbol = {"$", "&", "#", "%"};

    public Deck() {

    }

    public Card dealCard() {
        Card card = deck.get(0);
        deck.remove(card);
        return card;
    }

    public void initializeFullDeck() {

        if (deck.size() > 0) {
            this.deck.clear();
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 2; i < 15; i++) {
                if (i < 11) {
                    this.deck.add(new Card(this.symbol[j], Integer.toString(i)));
                } else {
                    switch (i) {
                        case 11:
                            this.deck.add(new Card(this.symbol[j], "J"));
                            break;
                        case 12:
                            this.deck.add(new Card(this.symbol[j], "Q"));
                            break;
                        case 13:
                            this.deck.add(new Card(this.symbol[j], "K"));
                            break;
                        case 14:
                            this.deck.add(new Card(this.symbol[j], "A"));
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void empty() {
        this.deck.clear();
    }

    public void print() {
        String tor = "";
        for (Card card : this.deck) {
            tor += " " + card.toString();
        }
        System.out.println("Deck: " + tor);
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card getRandomCard() {
        Card randomCard = this.deck.get(ThreadLocalRandom.current().nextInt(this.deck.size()));
        this.deck.remove(randomCard);
        return randomCard;
    }

    public void addCardToDeck(Card card) {
        this.deck.add(card);
    }

    public int getHeartsOnDeck() {
        int i = 0;
        for (Card card : this.deck) {
            if (card.isHeart())
                i++;
        }
        return i;
    }

    public Card getLastCard() {
        return this.deck.get(deck.size() - 1);
    }
}
