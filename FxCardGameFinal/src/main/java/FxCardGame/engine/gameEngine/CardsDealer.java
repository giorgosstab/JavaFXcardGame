/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;

/**
 * @author Been Touched
 */
public interface CardsDealer {
    public void showDeck();

    public Card dealRandomCard();

    void dealToPlayers(CardsPlayer player1, CardsPlayer player2);

    void decideWinner(CardsPlayer player1, CardsPlayer player2);
}
