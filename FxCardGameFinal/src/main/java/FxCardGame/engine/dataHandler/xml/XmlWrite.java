package FxCardGame.engine.dataHandler.xml;


import FxCardGame.engine.dataHandler.recordStruct.Game;
import FxCardGame.engine.dataHandler.recordStruct.GameRecord;
import FxCardGame.engine.dataHandler.recordStruct.PlayerSetRecord;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;


/**
 * Created by Been Touched on 11/12/2016.
 */
public class XmlWrite {


    public XmlWrite() throws JAXBException {
    }


    public static void writeGame(GameRecord game) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(GameRecord.class, Game.class, PlayerSetRecord.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            GameRecord gr;
            XmlRead xmlR = new XmlRead();
            gr = xmlR.getGameRecord();
            if (gr != null) {
                gr.add(game);
                marshaller.marshal(gr, new File("history.xml"));
            } else {
                marshaller.marshal(game, new File("history.xml"));
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
