/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;


/**
 * @author Been Touched
 */
public class HeartsPlayer extends Human {

    private Deck deck = new Deck();
    private String nickname;
    private int points;


    public HeartsPlayer(String name, String surname, int age, String nickname) {
        super(name, surname, age);
        this.nickname = nickname;
        this.points = 0;
    }


    public void dealCardTo(Card card) {
        this.deck.addCardToDeck(card);
    }

    public int getPoints() {
        return this.points;
    }

    public int getHeartsOnDeck() {
        return this.deck.getHeartsOnDeck();
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void printDeck() {
        this.deck.print();
    }

    public String getName() {
        return this.name;
    }

    void emptyDeck() {
        this.deck.empty();
    }

    Card getLastCard() {
        return deck.getLastCard();
    }

    public Deck getDeck() {
        return deck;
    }


    public String getNickname() {
        return nickname;
    }
}
