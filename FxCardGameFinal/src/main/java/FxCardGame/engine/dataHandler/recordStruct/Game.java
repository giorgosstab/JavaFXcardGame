package FxCardGame.engine.dataHandler.recordStruct;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Been Touched on 11/15/2016.
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Game")
public class Game {

    @SerializedName("player1")
    private PlayerSetRecord player1;

    @SerializedName("player2")
    private PlayerSetRecord player2;

    public Game(PlayerSetRecord p1, PlayerSetRecord p2) {
        player1 = p1;
        player2 = p2;
    }

    public Game() {
    }

    public PlayerSetRecord getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerSetRecord player1) {
        this.player1 = player1;
    }

    public PlayerSetRecord getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayerSetRecord player2) {
        this.player2 = player2;
    }

    @Override
    public String toString(){
        return "Player no 1: " + player1.getPlayerName() + ", Points: " + player1.getPlayerPoints()
                + "\n\tPlayer no 2: " + player2.getPlayerName() + ", Points: " + player2.getPlayerPoints();
    }

}