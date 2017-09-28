package FxCardGame.engine.dataHandler.xml;

import FxCardGame.engine.dataHandler.recordStruct.Game;
import FxCardGame.engine.dataHandler.recordStruct.GameRecord;
import FxCardGame.engine.dataHandler.recordStruct.PlayerSetRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Been Touched on 11/12/2016.
 */
public class XmlRead {
    private GameRecord gameRecord;

    public XmlRead() throws JAXBException {
    }

    public GameRecord getGameRecord() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(GameRecord.class, Game.class, PlayerSetRecord.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try {
            GameRecord record = (GameRecord) unmarshaller.unmarshal(new File("history.xml"));
            return record;
        } catch (Exception e) {
            return null;
        }
    }
}
