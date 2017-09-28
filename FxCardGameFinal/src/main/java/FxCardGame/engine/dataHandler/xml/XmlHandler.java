package FxCardGame.engine.dataHandler.xml;

import FxCardGame.engine.dataHandler.recordStruct.GameRecord;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Been Touched on 11/12/2016.
 */
public class XmlHandler {

    public XmlHandler() throws JAXBException {
    }

    public static void saveGame(GameRecord game) throws IOException {
        XmlWrite.writeGame(game);
    }

    public static GameRecord readGames() throws JAXBException {
        XmlRead xr = new XmlRead();
        return xr.getGameRecord();
    }
}
