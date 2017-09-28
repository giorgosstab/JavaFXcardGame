package FxCardGame.engine.dataHandler;

import FxCardGame.engine.dataHandler.json.JsonHandler;
import FxCardGame.engine.dataHandler.json.JsonRead;
import FxCardGame.engine.dataHandler.recordStruct.GameRecord;
import FxCardGame.engine.dataHandler.xml.XmlHandler;
import FxCardGame.engine.dataHandler.xml.XmlRead;
import FxCardGame.engine.gameEngine.Hearts;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Been Touched on 11/12/2016.
 */

public class DataHandler {

    public SaveType getSaveType() {
        return saveType;
    }

    public static SaveType saveType;

    public static void setSaveType(SaveType _saveType) {
        saveType = _saveType;
    }

    public void saveGame(Hearts.Game game) throws IOException {
        if (saveType == SaveType.JSON) {
            JsonHandler.saveGame(new GameRecord(game));
        } else if (saveType == SaveType.XML) {
            XmlHandler.saveGame(new GameRecord(game));
        } else {
            JsonHandler.saveGame(new GameRecord(game));
            XmlHandler.saveGame(new GameRecord(game));
        }
    }


    public List<GameRecord> readGame() {
        if(saveType == SaveType.JSON){
            JsonRead rd = new JsonRead();
            try {
                return Arrays.asList(rd.jsonRead());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(saveType == SaveType.XML){
            XmlRead xr = null;
            try {
                xr = new XmlRead();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            try {
                return Arrays.asList(xr.getGameRecord());
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }else{
            JsonRead rd = new JsonRead();
            XmlRead xr = null;
            try {
                xr = new XmlRead();
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            try {
                return Arrays.asList(xr.getGameRecord(),rd.jsonRead());
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public enum SaveType {
        JSON,
        XML,
        BOTH
    }
}
