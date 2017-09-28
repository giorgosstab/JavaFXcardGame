package FxCardGame.engine.dataHandler.recordStruct;

import FxCardGame.engine.gameEngine.Hearts;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;


/**
 * Created by Been Touched on 11/12/2016.
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GameRecord")
public class GameRecord {

    @SerializedName("Game")
    @XmlElement(name = "Game")
    private ArrayList<Game> games = new ArrayList<>();

    public GameRecord(Hearts.Game game) {
        games.add(new Game(new PlayerSetRecord(game.getPlayers().get(0).getNickname(), game.getPlayers().get(0).getPoints()), new PlayerSetRecord(game.getPlayers().get(1).getNickname(), game.getPlayers().get(1).getPoints())));
    }

    public GameRecord() {
    }

    @Override
    public String toString() {
        if (games != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Game Record \n");
            for (Game game : games) {
                sb.append("Game no " + games.indexOf(game) + "\n");
                sb.append("\t" + game.toString() + "\n");
            }
            return sb.toString();
        }else{
            return "No games recorded.";
        }

    }
    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public void add(Game game) {
        games.add(game);
    }

    public void add(GameRecord gameRecord) {
        PlayerSetRecord g1 = new PlayerSetRecord(gameRecord.getGames().get(0).getPlayer1().getPlayerName(), gameRecord.getGames().get(0).getPlayer1().getPlayerPoints());
        PlayerSetRecord g2 = new PlayerSetRecord(gameRecord.getGames().get(0).getPlayer2().getPlayerName(), gameRecord.getGames().get(0).getPlayer2().getPlayerPoints());
        games.add(new Game(g1, g2));
    }
}
