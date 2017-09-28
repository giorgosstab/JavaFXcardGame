/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxCardGame.engine.gameEngine;

import FxCardGame.engine.dataHandler.DataHandler;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Been Touched
 */
public class Hearts {

    /**
     * @param args the command line arguments
     */
    public static class Game {

        private boolean gameRunning = false;
        private ArrayList<HeartsPlayer> player = new ArrayList<HeartsPlayer>();
        private HeartsDealer gameDealer;
        private Boolean roundFinished;
        private HeartsPlayer winner;

        public Game(int rounds, String p1name, String p2name, String p1Surname, String p2surname, String p1nick, String p2nick) {
            roundFinished = false;
            gameRunning = true;
            gameDealer = new HeartsDealer();
            player.add(new HeartsPlayer(p1name, p1Surname, 20, p1nick));
            player.add(new HeartsPlayer(p2name, p2surname, 20, p2nick));
        }

        public void initNewRound() {
            winner = null;
            roundFinished = false;
        }

        public HeartsDealer getGameDealer() {
            return this.gameDealer;
        }

        private HeartsPlayer playRounds(HeartsDealer dealer, ArrayList<HeartsPlayer> player, int rounds) {
            for (int i = 1; i <= rounds; i++) {
                System.out.println("-----------------\nGame no. " + (i) + ".\n ");
                dealer.cardsPickUp(player);
            }
            HeartsPlayer winner = dealer.decideWinner(player.get(0), player.get(1));
            return winner;
        }

        public void dealToPlayers() {
            gameDealer.dealToPlayers(player.get(0), player.get(1));
        }

        public ArrayList<HeartsPlayer> getPlayers() {
            return player;
        }

        public boolean getGameRunning() {
            return this.gameRunning;
        }


        public void decideWinner() {
            gameDealer.arrangePoints(player.get(0), player.get(1));
            winner = gameDealer.decideWinner(player.get(0), player.get(1));
            gameDealer.initDealer();
            roundFinished = true;
        }

        public HeartsPlayer getWinner() {
            return winner;
        }

        public void endRound() throws JAXBException, IOException {
            saveRound();
            roundFinished = true;
            gameDealer.cardsPickUp(player);
        }

        public void saveRound() throws JAXBException, IOException {
            DataHandler tor = new DataHandler();
            tor.saveGame(this);
        }
    }
}
