package FxCardGame.engine.dataHandler.recordStruct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Been Touched on 11/15/2016.
 */

@XmlRootElement(name = "PlayerSetRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSetRecord {

    @SerializedName("playerName")
    private String playerName;

    @SerializedName("playerPoints")
    private Integer playerPoints;

    public PlayerSetRecord() {
    }

    public PlayerSetRecord(String name, Integer points) {
        this.playerName = name;
        this.playerPoints = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(Integer playerPoints) {
        this.playerPoints = playerPoints;
    }
}
