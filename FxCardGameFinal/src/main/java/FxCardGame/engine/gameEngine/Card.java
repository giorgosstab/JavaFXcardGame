/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;

/**
 * @author Been Touched
 */
public class Card {
    private String symbol;
    private String number;

    public Card(String symbol, String number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String toString() {
        return symbol + number;
    }

    public boolean isHeart() {
        return symbol.equals("#") ? true : false;
    }

}
